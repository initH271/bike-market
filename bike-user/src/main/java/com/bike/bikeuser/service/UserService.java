package com.bike.bikeuser.service;


import com.bike.bikecommon.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    Integer signUp(User user);

    User signIn(User user);

    User viewUserInfo(User user);

    User modifyUserInfo(User user);

    PageInfo<User> addUser(User user);

    PageInfo<User> deleteUser(User user);

    PageInfo<User> modifyUser(User user);

    PageInfo<User> queryUserList(User user);

    PageInfo<User> searchUser(User user);
}
