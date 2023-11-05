package com.bike.bikeuser.service.impl;

import com.bike.bikecommon.entity.Administrator;
import com.bike.bikeuser.mapper.AdministratorMapper;
import com.bike.bikeuser.service.AdministratorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    /**
     * 管理员登录
     *
     * @param administrator 管理员账号和密码
     * @return 用户的姓名
     */
    public Administrator signIn(Administrator administrator) {
        return administratorMapper.selectAdministratorByAccountAndPassword(administrator);
    }

    /**
     * 添加管理员
     *
     * @param administrator 管理员的id
     * @return 删除后剩下的管理员
     */
    public PageInfo<Administrator> addAdministrator(Administrator administrator) {
        administratorMapper.insertAdministrator(administrator);
        return queryAdministratorList(administrator);
    }

    /**
     * 删除管理员
     *
     * @param administrator 管理员的id
     * @return 删除后剩下的管理员
     */
    public PageInfo<Administrator> deleteAdministrator(Administrator administrator) {
        administratorMapper.deleteAdministratorById(administrator);
        return queryAdministratorList(administrator);
    }

    /**
     * 去修改
     *
     * @param administrator 管理员的唯一标识
     * @return 管理员的信息
     */
    public Administrator viewAdministratorInfo(Administrator administrator) {
        return administratorMapper.selectAdministratorById(administrator);
    }

    /**
     * 修改管理员
     *
     * @param administrator 需要修改的信息
     * @return 修改后的所有管理员信息
     */
    public PageInfo<Administrator> modifyAdministrator(Administrator administrator) {
        administratorMapper.updateAdministratorById(administrator);
        return queryAdministratorList(administrator);
    }

    /**
     * 查询管理员
     *
     * @return 管理员列表
     */
    public PageInfo<Administrator> queryAdministratorList(Administrator administrator) {
        PageHelper.startPage(administrator.getPageNow(), administrator.getPageSizeOfSuf());
        List<Administrator> administrators = administratorMapper.selectAdministratorList();
        return new PageInfo<>(administrators);
    }

    /**
     * 搜索管理员
     *
     * @param administrator 指定管理员的属性
     * @return 管理员列表
     */
    public PageInfo<Administrator> searchAdministrator(Administrator administrator) {
        PageHelper.startPage(administrator.getPageNow(), administrator.getPageSizeOfSuf());
        List<Administrator> administrators = administratorMapper.selectAdministratorListByAttribute(administrator);
        return new PageInfo<>(administrators);
    }
}
