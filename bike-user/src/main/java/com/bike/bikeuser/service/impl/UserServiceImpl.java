package com.bike.bikeuser.service.impl;

import com.bike.bikecommon.entity.User;
import com.bike.bikeuser.mapper.UserMapper;
import com.bike.bikeuser.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param user 用户提交的信息
     * @return 操作成功的条数
     */
    public Integer signUp(User user) {
        if (userMapper.selectUserByAccount(user) == null) {
            return userMapper.insertUserByAccountAndPassword(user);
        }
        return null;
    }

    /**
     * 用户登录
     *
     * @param user 用户账号和密码
     * @return 用户的昵称
     */
    public User signIn(User user) {
        return userMapper.selectUserByAccountAndPassword(user);
    }

    /**
     * 查看个人信息
     *
     * @param user 用户的id
     * @return 用户的所有信息
     */
    public User viewUserInfo(User user) {
        return userMapper.selectUserById(user);
    }

    /**
     * 修改个人信息
     *
     * @param user 用户要修改的信息
     * @return 用户修改后的信息
     */
    public User modifyUserInfo(User user) {
        userMapper.updateUserById(user);
        return userMapper.selectUserById(user);
    }

    /**
     * 添加用户
     *
     * @param user 用户的基本信息
     * @return 之前以及添加后的用户
     */
    public PageInfo<User> addUser(User user) {
        if (userMapper.selectUserByAccount(user) == null) {
            userMapper.insertUser(user);
            return queryUserList(user);
        }
        return null;
    }

    /**
     * 删除用户
     *
     * @param user 用户的id
     * @return 删除后剩下的用户
     */
    public PageInfo<User> deleteUser(User user) {
        userMapper.deleteUserById(user);
        return queryUserList(user);
    }

    /**
     * 修改用户
     *
     * @param user 需要修改的信息
     * @return 修改后的所有用户信息
     */
    public PageInfo<User> modifyUser(User user) {
        userMapper.updateUserById(user);
        return queryUserList(user);
    }

    /**
     * 查询用户
     *
     * @return 用户列表
     */
    public PageInfo<User> queryUserList(User user) {
        PageHelper.startPage(user.getPageNow(), user.getPageSizeOfSuf());
        List<User> users = userMapper.selectUserList();
        return new PageInfo<>(users);
    }

    /**
     * 搜索用户
     *
     * @param user 指定用户的属性
     * @return 用户列表
     */
    public PageInfo<User> searchUser(User user) {
        PageHelper.startPage(user.getPageNow(), user.getPageSizeOfSuf());
        List<User> users = userMapper.selectUserListByAttribute(user);
        return new PageInfo<>(users);
    }
}
