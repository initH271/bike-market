package com.bike.bikeuser.controller;

import com.bike.bikecommon.entity.User;
import com.bike.bikeuser.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户注册
     *
     * @param user 用户
     * @return true 注册成功
     */
    @RequestMapping("/signUp")
    public boolean signUp(User user) {
        if (userService.signUp(user) != null) {
            return true;
        }
        return false;
    }

    /**
     * 用户登录
     *
     * @param user 用户
     * @return 返回获取的用户信息
     */
    @RequestMapping("/signIn")
    public User signIn(@RequestBody User user) {
        User result = userService.signIn(user);
        return result;
    }


    /**
     * 查看用户信息
     *
     * @param user 用户的id
     * @return 跳转界面
     */
    @RequestMapping("/viewUserInfo")
    public User viewPersInfo(@RequestBody User user) {
        User resultUser = userService.viewUserInfo(user);
        return resultUser;
    }

    /**
     * 修改用户信息
     *
     * @param user 需要修改的数据
     * @return 修改后的数据
     */
    @RequestMapping("/modifyUserInfo")
    public User modifyPersInfo(@RequestBody User user) {
        User userAfterModify = userService.modifyUserInfo(user);
        return userAfterModify;
    }

    /**
     * 添加用户
     *
     * @param user 需要添加用户的信息
     * @return 跳转界面
     */
    @RequestMapping("/addUser")
    public PageInfo<User> addUser(@RequestBody User user) {
        PageInfo<User> userPageInfo = userService.addUser(user);
        return userPageInfo;
    }

    /**
     * 删除用户
     *
     * @param user 用户的id
     * @return 跳转界面
     */
    @RequestMapping("/deleteUser")
    public PageInfo<User> deleteUser(@RequestBody User user) {
        PageInfo<User> userPageInfo = userService.deleteUser(user);
        return userPageInfo;
    }

    /**
     * 修改用户
     *
     * @param user 需要修改的用户信息
     * @return 跳转界面
     */
    @RequestMapping("/modifyUser")
    public PageInfo<User> modifyUser(@RequestBody User user) {
        PageInfo<User> userPageInfo = userService.modifyUser(user);

        return userPageInfo;
    }

    /**
     * 查询所有用户 以列表形式展示
     *
     * @return 用户列表界面
     */
    @RequestMapping("/queryUserList")
    public PageInfo<User> queryUserList(@RequestBody User user) {
        PageInfo<User> userPageInfo = userService.queryUserList(user);
        return userPageInfo;
    }

    /**
     * 搜索用户
     *
     * @return 用户列表界面
     */
    @RequestMapping("/searchUser")
    public PageInfo<User> searchUser(@RequestBody User user) {
        PageInfo<User> userPageInfo = userService.searchUser(user);
        return userPageInfo;
    }
}