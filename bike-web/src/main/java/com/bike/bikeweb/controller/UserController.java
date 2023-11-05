package com.bike.bikeweb.controller;

import com.bike.bikecommon.client.UserClient;
import com.bike.bikecommon.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserClient userClient;

    /**
     * 去首页
     *
     * @return 首页
     */
    @RequestMapping("/")
    public ModelAndView toHome(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/home");
        return modelAndView;
    }

    /**
     * 用户去注册
     *
     * @return 用户登注册界面
     */
    @RequestMapping("/toSignUp")
    public ModelAndView toSignUp(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/sign_up");
        return modelAndView;
    }

    /**
     * 用户去登录
     *
     * @return 用户登录界面
     */
    @RequestMapping("/toSignIn")
    public ModelAndView toSignIn(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/sign_in");
        return modelAndView;
    }

    /**
     * 用户注册
     *
     * @param user 用户
     * @return 跳转注册界面或者登录界面
     */
    @RequestMapping("/signUp")
    public ModelAndView signUp(ModelAndView modelAndView, User user) {

        // 注册成功
        if (userClient.userSignUp(user)) {
            modelAndView.setViewName("/user/sign_in");
        } else {
            modelAndView.setViewName("/user/sign_up");
        }

        return modelAndView;
    }

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return 跳转到首页或者登录界面
     */
    @RequestMapping("/signIn")
    public ModelAndView signIn(User user, HttpSession session, ModelAndView modelAndView) {
        // TODO: 请求用户服务的signIn接口
        User result = userClient.userSignIn(user);
        // 如果用户登录成功，将用户信息放入session中
        if (result != null) {
            String userNickname = result.getNickname();
            if (userNickname.length() >= 3) {
                String nickname = userNickname.substring(0, 3) + "...";
                result.setNickname(nickname);
            }
            session.setAttribute("user", result);
            modelAndView.setViewName("/user/home");
        } else {
            // 如果用户登录失败
            modelAndView.setViewName("/user/sign_in");

        }
        return modelAndView;
    }

    /**
     * 用户退出
     *
     * @return 超市首页
     */
    @RequestMapping("/signOut")
    public ModelAndView signOut(HttpSession session, ModelAndView modelAndView) {
        session.removeAttribute("user");
        // 重定向至/
        modelAndView.setViewName("redirect:/");
        modelAndView.setStatus(HttpStatus.FOUND);
        return modelAndView;
    }

    /**
     * 查看用户信息
     *
     * @param user 用户的id
     * @return 跳转界面
     */
    @RequestMapping("/viewUserInfo")
    public ModelAndView viewPersInfo(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", userClient.userViewPersInfo(user));
        modelAndView.setViewName("/user/user_info");
        return modelAndView;
    }

    /**
     * 修改用户信息
     *
     * @param user 需要修改的数据
     * @return 修改后的数据
     */
    @RequestMapping("/modifyUserInfo")
    public ModelAndView modifyPersInfo(ModelAndView modelAndView, User user) {
        User userAfterModify = userClient.userModifyPersInfo(user);
        modelAndView.addObject("user", userAfterModify);
        modelAndView.setViewName("/user/user_info");
        return modelAndView;
    }

    /**
     * 去添加用户
     *
     * @return 用户增加界面
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(ModelAndView modelAndView) {
        modelAndView.setViewName("/administrator/user_add");
        return modelAndView;
    }

    /**
     * 添加用户
     *
     * @param user 需要添加用户的信息
     * @return 跳转界面
     */
    @RequestMapping("/addUser")
    public ModelAndView addUser(ModelAndView modelAndView, User user) {
        PageInfo<User> userPageInfo = userClient.userAddUser(user);
        modelAndView.addObject("users", userPageInfo.getList());
        modelAndView.addObject("page", userPageInfo);
        modelAndView.setViewName("/administrator/user_list");
        return modelAndView;
    }

    /**
     * 删除用户
     *
     * @param user  用户的id
     * @param model 删除后剩下的用户
     * @return 跳转界面
     */
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(ModelAndView model, User user) {
        PageInfo<User> userPageInfo = userClient.userDeleteUser(user);
        model.addObject("users", userPageInfo.getList());
        model.addObject("page", userPageInfo);
        model.setViewName("/administrator/user_list");
        return model;
    }

    /**
     * 去修改用户
     *
     * @param model 存放用户原来的数据
     * @param user  用户id
     * @return 用户修改界面
     */
    @RequestMapping("/toModify")
    public ModelAndView toModify(ModelAndView model, User user) {
        User userInMysql = userClient.userViewPersInfo(user);
        model.addObject("user", userInMysql);
        model.setViewName("/administrator/user_modify");
        return model;
    }

    /**
     * 修改用户
     *
     * @param user  需要修改的用户信息
     * @param model 修改后的所有用户的信息
     * @return 跳转界面
     */
    @RequestMapping("/modifyUser")
    public ModelAndView modifyUser(ModelAndView model, User user) {
        PageInfo<User> userPageInfo = userClient.userModifyUser(user);
        model.addObject("users", userPageInfo.getList());
        model.addObject("page", userPageInfo);
        model.setViewName("/administrator/user_list");
        return model;
    }

    /**
     * 查询所有用户 以列表形式展示
     *
     * @param model 存放用户的数据
     * @return 用户列表界面
     */
    @RequestMapping("/queryUserList")
    public ModelAndView queryUserList(ModelAndView model, User user) {
        PageInfo<User> userPageInfo = userClient.userQueryUserList(user);
        model.addObject("users", userPageInfo.getList());
        model.addObject("page", userPageInfo);
        model.setViewName("/administrator/user_list");
        return model;
    }

    /**
     * 搜索用户
     *
     * @param model 存放多个用户的数据
     * @return 用户列表界面
     */
    @RequestMapping("/searchUser")
    public ModelAndView searchUser(ModelAndView model, User user) {
        PageInfo<User> userPageInfo = userClient.userSearchUser(user);
        model.addObject("users", userPageInfo.getList());
        model.addObject("page", userPageInfo);
        model.setViewName("administrator/user_list_search");
        return model;
    }


}
