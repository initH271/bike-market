package com.bike.bikeuser;

import com.bike.bikecommon.entity.Administrator;
import com.bike.bikeuser.controller.AdministratorController;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BikeUserApplicationTests {

    @Autowired
    AdministratorController administratorController;

    @Test
    void AdministratorControllerTest() {
        PageInfo<Administrator> info = administratorController.addAdministrator(
                new Administrator(19985, "5312", "123456", "zs", "张三", "1558563875"));
        System.out.println(info.toString());
    }

}
