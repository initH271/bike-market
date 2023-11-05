package com.bike.bikecontent.controller;

import com.bike.bikecommon.entity.Bike;
import com.bike.bikecontent.service.BikeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2023/11/4
 * Author:丐版小杨哥
 * Description:
 */
@RestController
@RequestMapping("/content-api")
public class BikeController {
    @Autowired
    private BikeService bikeService;

    /**
     * 去添加商品
     *
     * @return 商品增加界面
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "administrator/bike_add";
    }

    /**
     * 添加商品
     *
     * @param bike 需要添加商品的信息
     *             添加成功后返回一个分页数据
     */
    @RequestMapping("/addBike")
    public PageInfo<Bike> addBike(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.addBike(bike);
        return bikePageInfo;
    }

    /**
     * 删除商品
     *
     * @param bike 商品的id
     * @return 跳转界面
     */
    @RequestMapping("/deleteBike")
    public PageInfo<Bike> deleteBike(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.deleteBike(bike);
        return bikePageInfo;
    }

    /**
     * 去修改商品
     *
     * @param bike 商品id
     * @return 商品修改界面
     */
    @RequestMapping("/toModify")
    public Bike toModify(@RequestBody Bike bike) {
        Bike bikeInMysql = bikeService.viewBikeInfo(bike);
        return bikeInMysql;
    }

    /**
     * 修改商品
     *
     * @param bike 需要修改的商品信息
     * @return 跳转界面
     */
    @RequestMapping("/modifyBike")
    public PageInfo<Bike> modifyBike(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.modifyBike(bike);
        return bikePageInfo;
    }

    /**
     * 展示商品列表
     *
     * @param bike 存放分页数据
     * @return 商品列表页面
     */
    @RequestMapping("/queryBikeListOfPre")
    public PageInfo<Bike> queryBikeListOfPre(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.queryBikeListOfPre(bike);
        return bikePageInfo;
    }

    /**
     * 查询所有商品
     *
     * @return 商品列表界面
     */
    @RequestMapping("/queryBikeListOfSuf")
    public PageInfo<Bike> queryBikeListOfSuf(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.queryBikeListOfSuf(bike);
        return bikePageInfo;
    }

    /**
     * 前台搜索商品
     *
     * @return 商品列表界面
     */
    @RequestMapping("/searchBikeOfPre")
    public PageInfo<Bike> searchBikeOfPre(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.searchBikeOfPre(bike);
        return bikePageInfo;
    }

    /**
     * 后台搜索商品
     *
     * @return 商品列表界面
     */
    @RequestMapping("/searchBikeOfSuf")
    public PageInfo<Bike> searchBikeOfSuf(@RequestBody Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeService.searchBikeOfSuf(bike);
        return bikePageInfo;
    }

    /**
     * 查看商品的信息
     *
     * @return 商品展示页
     */
    @RequestMapping("/viewBikeInfo")
    public Bike viewBikeInfo(@RequestBody Bike bike) {
        Bike bikeInMysql = bikeService.viewBikeInfo(bike);
        return bikeInMysql;
    }

    /**
     * 获取所有bike的信息
     *
     * @return 所有bike的信息
     */
    @RequestMapping("/queryBikeList")
    public List<Bike> queryBikeList(@RequestBody List<Integer> bikeIdList) {
        List<Bike> bikeList = bikeService.queryBikeList(bikeIdList);
        return bikeList;
    }
}
