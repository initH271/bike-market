package com.bike.bikeuser.controller;

import com.bike.bikecommon.entity.Administrator;
import com.bike.bikeuser.service.AdministratorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date:2023/11/4
 * Author:丐版小杨哥
 * Description:
 */
@RestController
@RequestMapping("user-api/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    /**
     * 管理员登录
     *
     * @param administrator 管理员
     * @return true登录成功
     */
    @RequestMapping("/signIn")
    public Administrator signIn(@RequestBody Administrator administrator) {
        Administrator administratorInMysql = administratorService.signIn(administrator);
        return administratorInMysql;
    }

    @RequestMapping("/viewAdministratorInfo")
    public Administrator adminViewAdministratorInfo(@RequestBody Administrator administrator) {
        Administrator resultAdministrator = administratorService.viewAdministratorInfo(administrator);
        return resultAdministrator;
    }


    /**
     * 添加管理员
     *
     * @param administrator 需要添加管理员的信息
     * @return 返回到管理员列表页
     */
    @RequestMapping("/addAdministrator")
    public PageInfo<Administrator> addAdministrator(@RequestBody Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = administratorService.addAdministrator(administrator);
        return administratorPageInfo;
    }

    /**
     * 删除管理员
     *
     * @param administrator 管理员的id
     * @return 返回到管理员列表页
     */
    @RequestMapping("/deleteAdministrator")
    public PageInfo<Administrator> deleteAdministrator(@RequestBody Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = administratorService.deleteAdministrator(administrator);
        return administratorPageInfo;
    }

    /**
     * 修改管理员
     *
     * @param administrator 需要修改的管理员信息
     * @return 返回到管理员列表页
     */
    @RequestMapping("/modifyAdministrator")
    public PageInfo<Administrator> modifyAdministrator(@RequestBody Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = administratorService.modifyAdministrator(administrator);
        return administratorPageInfo;
    }

    /**
     * 查询所有管理员
     *
     * @return 返回到管理员列表页
     */
    @RequestMapping("/queryAdministratorList")
    public PageInfo<Administrator> queryAdministratorList(@RequestBody Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = administratorService.queryAdministratorList(administrator);
        return administratorPageInfo;
    }

    /**
     * 搜索管理员
     *
     * @return 返回到管理员列表页
     */
    @RequestMapping("/searchAdministrator")
    public PageInfo<Administrator> searchAdministrator(@RequestBody Administrator administrator) {
        PageInfo<Administrator> administratorPageInfo = administratorService.searchAdministrator(administrator);
        return administratorPageInfo;
    }
}