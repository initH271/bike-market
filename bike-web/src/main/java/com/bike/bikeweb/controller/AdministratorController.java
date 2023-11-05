package com.bike.bikeweb.controller;

import com.bike.bikecommon.client.UserClient;
import com.bike.bikecommon.entity.Administrator;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    UserClient adminClient;

    /**
     * 去欢迎界面
     *
     * @return 欢迎页
     */
    @RequestMapping("/toWelcome")
    public ModelAndView toWelcome(ModelAndView modelAndView) {
        modelAndView.setViewName("/administrator/welcome");
        return modelAndView;
    }

    /**
     * 管理员去登录
     *
     * @return 登录界面
     */
    @RequestMapping("/")
    public ModelAndView toSignIn(ModelAndView modelAndView) {
        modelAndView.setViewName("/administrator/sign_in");
        return modelAndView;
    }

    /**
     * 管理员登录
     *
     * @param administrator 管理员
     * @param session       将用户信息存放在session中
     * @return 管理员首页
     */
    @RequestMapping("/signIn")
    public ModelAndView signIn(HttpSession session, ModelAndView model, Administrator administrator) {
        Administrator administratorInMysql = adminClient.adminSignIn(administrator);
        if (administratorInMysql != null) {
            session.setAttribute("administratorName", administratorInMysql.getName());
            model.setViewName("/administrator/home");
        } else {
            model.setViewName("/administrator/sign_in");
        }
        return model;
    }

    /**
     * 管理员退出
     *
     * @param session 会话
     * @return 返回到登录页
     */
    @RequestMapping("/signOut")
    public ModelAndView signOut(HttpSession session, ModelAndView model) {
        System.out.println(session.getAttribute("administratorName"));
        session.removeAttribute("administratorName");
        System.out.println(session.getAttribute("administratorName"));
        model.setViewName("/administrator/sign_in");
        return model;
    }

    /**
     * 去添加管理员
     *
     * @return 用户增加界面
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(ModelAndView modelAndView) {
        modelAndView.setViewName("/administrator/administrator_add");
        return modelAndView;
    }

    /**
     * 添加管理员
     *
     * @param administrator 需要添加管理员的信息
     * @param model         存放所有管理员的信息，包括刚才增加的
     * @return 返回到管理员列表页
     */
    @RequestMapping("/addAdministrator")
    public ModelAndView addAdministrator(ModelAndView model, Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = adminClient.adminAddAdministrator(administrator);
        model.addObject("administrators", administratorPageInfo.getList());
        model.addObject("page", administratorPageInfo);
        model.setViewName("/administrator/administrator_list");
        return model;
    }

    /**
     * 删除管理员
     *
     * @param administrator 管理员的id
     * @param model         删除后剩下的管理员
     * @return 返回到管理员列表页
     */
    @RequestMapping("/deleteAdministrator")
    public ModelAndView deleteAdministrator(ModelAndView model, Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = adminClient.adminDeleteAdministrator(administrator);
        model.addObject("administrators", administratorPageInfo.getList());
        model.addObject("page", administratorPageInfo);
        model.setViewName("/administrator/administrator_list");
        return model;
    }

    /**
     * 去修改管理员
     *
     * @param model         存放用户原来的数据
     * @param administrator 管理员id
     * @return 用户修改界面
     */
    @RequestMapping("/toModify")
    public ModelAndView toModify(ModelAndView model, Administrator administrator) {
        Administrator administratorInMysql = adminClient.adminViewAdministratorInfo(administrator);
        model.addObject("administrator", administratorInMysql);
        model.setViewName("/administrator/administrator_modify");
        return model;
    }

    /**
     * 修改管理员
     *
     * @param administrator 需要修改的管理员信息
     * @param model         修改后的所有管理员的信息
     * @return 返回到管理员列表页
     */
    @RequestMapping("/modifyAdministrator")
    public ModelAndView modifyAdministrator(ModelAndView model, Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = adminClient.adminModifyAdministrator(administrator);
        model.addObject("administrators", administratorPageInfo.getList());
        model.addObject("page", administratorPageInfo);
        model.setViewName("/administrator/administrator_list");
        return model;
    }

    /**
     * 查询所有管理员
     *
     * @param model 存放管理员的数据
     * @return 返回到管理员列表页
     */
    @RequestMapping("/queryAdministratorList")
    public ModelAndView queryAdministratorList(ModelAndView model, Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = adminClient.adminQueryAdministratorList(administrator);
        model.addObject("administrators", administratorPageInfo.getList());
        model.addObject("page", administratorPageInfo);
        model.setViewName("/administrator/administrator_list");
        return model;
    }

    /**
     * 搜索管理员
     *
     * @param model 存放多个管理员的数据
     * @return 返回到管理员列表页
     */
    @RequestMapping("/searchAdministrator")
    public ModelAndView searchAdministrator(ModelAndView model, Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = adminClient.adminSearchAdministrator(administrator);
        model.addObject("administrators", administratorPageInfo.getList());
        model.addObject("page", administratorPageInfo);
        model.setViewName("/administrator/administrator_list");
        return model;
    }
}
