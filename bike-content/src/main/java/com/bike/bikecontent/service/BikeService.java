package com.bike.bikecontent.service;

import com.bike.bikecommon.entity.Bike;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Date:2023/11/4
 * Author:丐版小杨哥
 * Description:
 */
public interface BikeService {
    /**
     * 添加商品
     *
     * @param bike
     * @return
     */
    PageInfo<Bike> addBike(Bike bike);

    PageInfo<Bike> deleteBike(Bike bike);

    Bike viewBikeInfo(Bike bike);

    PageInfo<Bike> modifyBike(Bike bike);

    PageInfo<Bike> queryBikeListOfPre(Bike bike);

    PageInfo<Bike> queryBikeListOfSuf(Bike bike);

    PageInfo<Bike> searchBikeOfPre(Bike bike);

    PageInfo<Bike> searchBikeOfSuf(Bike bike);

    List<Bike> queryBikeList(List<Integer> bikeIdList);
}
