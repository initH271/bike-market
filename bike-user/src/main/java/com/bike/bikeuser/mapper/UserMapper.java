package com.bike.bikeuser.mapper;


import com.bike.bikecommon.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer insertUserByAccountAndPassword(User user);

    Integer insertUser(User user);

    Integer deleteUserById(User user);

    Integer updateUserById(User user);

    User selectUserById(User user);

    User selectUserByAccount(User user);

    User selectUserByAccountAndPassword(User user);

    List<User> selectUserList();

    List<User> selectUserListByAttribute(User user);
}
