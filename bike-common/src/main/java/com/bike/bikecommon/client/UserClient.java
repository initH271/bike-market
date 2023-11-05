package com.bike.bikecommon.client;

import com.bike.bikecommon.entity.Administrator;
import com.bike.bikecommon.entity.User;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service")
public interface UserClient {

    /**
     * 用户登录接口
     *
     * @param user 包含用户名和密码
     * @return 用户信息
     */
    @RequestMapping("/user-api/signIn")
    User userSignIn(User user);

    /**
     * 用户注册接口
     *
     * @param user 用户
     * @return true 注册成功
     */
    @RequestMapping("/user-api/signUp")
    boolean userSignUp(User user);

    /**
     * 查看用户信息接口
     *
     * @param user 包含用户账号
     * @return 用户信息
     */
    @RequestMapping("/user-api/viewUserInfo")
    User userViewPersInfo(User user);

    /**
     * 修改用户信息接口
     *
     * @param user 需要修改的数据
     * @return 修改后的数据
     */
    @RequestMapping("/user-api/modifyUserInfo")
    User userModifyPersInfo(User user);

    /**
     * 添加用户接口
     *
     * @param user 需要添加用户的信息
     * @return 返回用户列表页信息
     */
    @RequestMapping("/user-api/addUser")
    PageInfo<User> userAddUser(User user);

    /**
     * 删除用户接口
     *
     * @param user 用户的账号
     * @return 返回用户列表页信息
     */
    @RequestMapping("/user-api/deleteUser")
    PageInfo<User> userDeleteUser(User user);

    /**
     * 修改用户接口
     *
     * @param user 需要修改的用户信息
     * @return 用户列表页信息
     */
    @RequestMapping("/user-api/modifyUser")
    PageInfo<User> userModifyUser(User user);

    /**
     * 查询用户接口
     *
     * @param user 用户信息
     * @return 用户列表页信息
     */
    @RequestMapping("/user-api/queryUserList")
    PageInfo<User> userQueryUserList(User user);

    /**
     * 搜索用户接口
     *
     * @param user 用户信息
     * @return 用户列表页信息
     */
    @RequestMapping("/user-api/searchUser")
    PageInfo<User> userSearchUser(User user);

    //
    //   管理员部分接口
    //

    /**
     * 管理员登录
     *
     * @param administrator 管理员
     * @return 管理员信息
     */
    @RequestMapping("user-api/administrator/signIn")
    Administrator adminSignIn(Administrator administrator);

    /**
     * 管理员信息查看
     *
     * @param administrator 管理员
     * @return 管理员信息
     */
    @RequestMapping("user-api/administrator/viewAdministratorInfo")
    Administrator adminViewAdministratorInfo(Administrator administrator);

    /**
     * 添加管理员
     *
     * @param administrator 需要添加管理员的信息
     * @return 管理员列表页信息
     */
    @RequestMapping("user-api/administrator/addAdministrator")
    PageInfo<Administrator> adminAddAdministrator(Administrator administrator);

    /**
     * 删除管理员
     *
     * @param administrator 管理员的id
     * @return 管理员列表页
     */
    @RequestMapping("user-api/administrator/deleteAdministrator")
    PageInfo<Administrator> adminDeleteAdministrator(Administrator administrator);

    /**
     * 修改管理员
     *
     * @param administrator 需要修改的管理员信息
     * @return 管理员列表页
     */
    @RequestMapping("user-api/administrator/modifyAdministrator")
    PageInfo<Administrator> adminModifyAdministrator(Administrator administrator);

    /**
     * 查询所有管理员
     *
     * @param administrator 管理员信息
     * @return 管理员列表页
     */
    @RequestMapping("user-api/administrator/queryAdministratorList")
    PageInfo<Administrator> adminQueryAdministratorList(Administrator administrator);

    /**
     * 搜索管理员
     *
     * @return 管理员列表页
     */
    @RequestMapping("user-api/administrator/searchAdministrator")
    PageInfo<Administrator> adminSearchAdministrator(Administrator administrator);
}
