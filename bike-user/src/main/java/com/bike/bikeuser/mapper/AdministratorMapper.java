package com.bike.bikeuser.mapper;


import com.bike.bikecommon.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorMapper {
    Integer insertAdministrator(Administrator Administrator);

    Integer deleteAdministratorById(Administrator Administrator);

    Integer updateAdministratorById(Administrator Administrator);

    Administrator selectAdministratorById(Administrator Administrator);

    Administrator selectAdministratorByAccountAndPassword(Administrator administrator);

    List<Administrator> selectAdministratorList();

    List<Administrator> selectAdministratorListByAttribute(Administrator Administrator);
}
