package com.bike.bikeweb.controller;

import com.bike.bikecommon.client.ContentClient;
import com.bike.bikecommon.entity.Bike;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    ContentClient bikeClient;

    /**
     * 去添加商品
     *
     * @return 商品增加界面
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(ModelAndView model) {
        model.setViewName("/administrator/bike_add");
        return model;
    }

    /**
     * 添加商品
     *
     * @param bike  需要添加商品的信息
     * @param model 存放所有商品的信息，包括刚才增加的
     * @return 跳转界面
     */
    @RequestMapping("/addBike")
    public ModelAndView addBike(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.addBike(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/administrator/bike_list");
        return model;
    }

    /**
     * 删除商品
     *
     * @param bike  商品的id
     * @param model 删除后剩下的商品
     * @return 跳转界面
     */
    @RequestMapping("/deleteBike")
    public ModelAndView deleteBike(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.deleteBike(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/administrator/bike_list");
        return model;
    }

    /**
     * 去修改商品
     *
     * @param model 存放商品原来的数据
     * @param bike  商品id
     * @return 商品修改界面
     */
    @RequestMapping("/toModify")
    public ModelAndView toModify(ModelAndView model, Bike bike) {
        Bike bikeInMysql = bikeClient.viewBikeInfo(bike);
        model.addObject("bike", bikeInMysql);
        model.setViewName("/administrator/bike_modify");
        return model;
    }

    /**
     * 修改商品
     *
     * @param bike  需要修改的商品信息
     * @param model 修改后的所有商品的信息
     * @return 跳转界面
     */
    @RequestMapping("/modifyBike")
    public ModelAndView modifyBike(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.modifyBike(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/administrator/bike_list");
        return model;
    }

    /**
     * 展示商品列表
     *
     * @param model 存放商品的数据
     * @param bike  存放分页数据
     * @return 商品列表页面
     */
    @RequestMapping("/queryBikeListOfPre")
    public ModelAndView queryBikeListOfPre(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.queryBikeListOfPre(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/user/bike_list");
        return model;
    }

    /**
     * 查询所有商品
     *
     * @param model 存放商品的数据
     * @return 商品列表界面
     */
    @RequestMapping("/queryBikeListOfSuf")
    public ModelAndView queryBikeListOfSuf(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.queryBikeListOfSuf(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/administrator/bike_list");
        return model;
    }

    /**
     * 前台搜索商品
     *
     * @param model 存放多个商品的数据
     * @return 商品列表界面
     */
    @RequestMapping("/searchBikeOfPre")
    public ModelAndView searchBikeOfPre(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.searchBikeOfPre(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/user/bike_list_search");
        return model;
    }

    /**
     * 后台搜索商品
     *
     * @param model 存放多个商品的数据
     * @return 商品列表界面
     */
    @RequestMapping("/searchBikeOfSuf")
    public ModelAndView searchBikeOfSuf(ModelAndView model, Bike bike) {
        PageInfo<Bike> bikePageInfo = bikeClient.searchBikeOfSuf(bike);
        model.addObject("bikes", bikePageInfo.getList());
        model.addObject("page", bikePageInfo);
        model.setViewName("/administrator/bike_list_search");
        return model;
    }

    /**
     * 查看商品的信息
     *
     * @param model 存放商品的数据
     * @return 商品展示页
     */
    @RequestMapping("viewBikeInfo")
    public ModelAndView viewBikeInfo(ModelAndView model, Bike bike) {
        Bike bikeInMysql = bikeClient.viewBikeInfo(bike);
        model.addObject("bike", bikeInMysql);
        model.setViewName("/user/bike_info");
        return model;
    }
}