package com.bike.bikecontent.mapper;

import com.bike.bikecommon.entity.Bike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BikeMapper {
    Integer insertBike(Bike Bike);

    Integer deleteBikeById(Bike Bike);

    Integer updateBikeById(Bike Bike);

    Bike selectBikeById(Bike Bike);

    List<Bike> selectBikeList();

    List<Bike> selectBikeListByAttribute(Bike Bike);

    Bike selectBikeById(Integer id);
}
