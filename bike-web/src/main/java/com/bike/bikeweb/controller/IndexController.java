package com.bike.bikeweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
    /**
     * 去首页
     *
     * @return 首页
     */
    @RequestMapping("/")
    public ModelAndView toHome(HttpSession session, ModelAndView modelAndView) {
        modelAndView.setViewName("/user/home");
        if (session.getAttribute("user") == null) {
            modelAndView.setViewName("/user/sign_in");
        }
        return modelAndView;
    }


    /**
     * 去管理后台
     *
     * @return 管理后台
     */
    @RequestMapping("/admin")
    public ModelAndView toAdmin(HttpSession session, ModelAndView modelAndView) {
        modelAndView.setViewName("/administrator/home");
        if (session.getAttribute("administratorName") == null) {
            modelAndView.setViewName("/administrator/sign_in");
        }
        return modelAndView;
    }

}
