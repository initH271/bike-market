package com.bike.bikeuser.service;

import com.bike.bikecommon.entity.Administrator;
import com.github.pagehelper.PageInfo;

public interface AdministratorService {
    Administrator signIn(Administrator administrator);

    Administrator viewAdministratorInfo(Administrator administrator);

    PageInfo<Administrator> addAdministrator(Administrator administrator);

    PageInfo<Administrator> deleteAdministrator(Administrator administrator);

    PageInfo<Administrator> modifyAdministrator(Administrator administrator);

    PageInfo<Administrator> queryAdministratorList(Administrator administrator);

    PageInfo<Administrator> searchAdministrator(Administrator administrator);
}
