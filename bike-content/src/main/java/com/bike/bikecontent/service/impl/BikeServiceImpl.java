package com.bike.bikecontent.service.impl;

import com.bike.bikecommon.entity.Bike;
import com.bike.bikecontent.mapper.BikeMapper;
import com.bike.bikecontent.service.BikeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Date:2023/11/4
 * Author:丐版小杨哥
 * Description:
 */
@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    BikeMapper bikeMapper;

    /**
     * 查看商品信息
     *
     * @param bike 商品的id
     * @return 商品的所有信息
     */
    public Bike viewBikeInfo(Bike bike) {
        return bikeMapper.selectBikeById(bike.getId());
    }

    /**
     * 添加商品
     *
     * @param bike 商品的基本信息
     * @return 之前以及添加后的商品
     */
    public PageInfo<Bike> addBike(Bike bike) {
        bikeMapper.insertBike(bike);
        return queryBikeListOfSuf(bike);
    }

    /**
     * 删除商品
     *
     * @param bike 商品的id
     * @return 删除后剩下的商品
     */
    public PageInfo<Bike> deleteBike(Bike bike) {
        bikeMapper.deleteBikeById(bike);
        return queryBikeListOfSuf(bike);
    }

    /**
     * 修改商品
     *
     * @param bike 需要修改的信息
     * @return 修改后的所有商品信息
     */
    public PageInfo<Bike> modifyBike(Bike bike) {
        bikeMapper.updateBikeById(bike);
        return queryBikeListOfSuf(bike);
    }

    /**
     * 展示商品
     *
     * @return 商品列表
     */
    public PageInfo<Bike> queryBikeListOfPre(Bike bike) {
        PageHelper.startPage(bike.getPageNow(), bike.getPageSizeOfPre());
        List<Bike> bikes = bikeMapper.selectBikeList();
        return new PageInfo<>(bikes);
    }

    /**
     * 查询商品
     *
     * @return 商品列表
     */
    public PageInfo<Bike> queryBikeListOfSuf(Bike bike) {
        PageHelper.startPage(bike.getPageNow(), bike.getPageSizeOfSuf());
        List<Bike> bikes = bikeMapper.selectBikeList();
        return new PageInfo<>(bikes);

    }

    /**
     * 前台搜索商品
     *
     * @param bike 指定商品的属性
     * @return 商品列表
     */
    public PageInfo<Bike> searchBikeOfPre(Bike bike) {
        PageHelper.startPage(bike.getPageNow(), bike.getPageSizeOfPre());
        List<Bike> bikes = bikeMapper.selectBikeListByAttribute(bike);
        return new PageInfo<>(bikes);
    }

    /**
     * 后台搜索商品
     *
     * @param bike 指定商品的属性
     * @return 商品列表
     */
    public PageInfo<Bike> searchBikeOfSuf(Bike bike) {
        PageHelper.startPage(bike.getPageNow(), bike.getPageSizeOfSuf());
        List<Bike> bikes = bikeMapper.selectBikeListByAttribute(bike);
        return new PageInfo<>(bikes);
    }

    /**
     * 查询商品列表
     *
     * @param bikeIdList 商品id列表
     * @return 商品列表
     */
    @Override
    public List<Bike> queryBikeList(List<Integer> bikeIdList) {
        ArrayList<Bike> bikes = new ArrayList<>();
        bikeIdList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer id) {
                bikes.add(bikeMapper.selectBikeById(id));
            }
        });
        return bikes;
    }
}
