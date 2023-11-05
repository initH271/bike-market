package com.bike.bikecommon.client;

import com.bike.bikecommon.entity.Bike;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "content-service")
public interface ContentClient {

    /**
     * 添加商品
     *
     * @param bike 需要添加商品的信息
     *             添加成功后返回一个分页数据
     */
    @RequestMapping("/content-api/addBike")
    PageInfo<Bike> addBike(Bike bike);

    /**
     * 删除商品
     *
     * @param bike 商品的id
     * @return 跳转界面
     */
    @RequestMapping("/content-api/deleteBike")
    PageInfo<Bike> deleteBike(Bike bike);

    /**
     * 修改商品
     *
     * @param bike 需要修改的商品信息
     * @return 修改后的分页数据
     */
    @RequestMapping("/content-api/modifyBike")
    PageInfo<Bike> modifyBike(Bike bike);

    /**
     * 展示商品列表
     *
     * @param bike 存放分页数据
     * @return 商品列表分页数据
     */
    @RequestMapping("/content-api/queryBikeListOfPre")
    PageInfo<Bike> queryBikeListOfPre(Bike bike);

    /**
     * 查询所有商品
     *
     * @return 商品列表分页数据
     */
    @RequestMapping("/content-api/queryBikeListOfSuf")
    PageInfo<Bike> queryBikeListOfSuf(Bike bike);

    /**
     * 前台搜索商品
     *
     * @return 商品列表分页数据
     */
    @RequestMapping("/content-api/searchBikeOfPre")
    PageInfo<Bike> searchBikeOfPre(Bike bike);

    /**
     * 后台搜索商品
     *
     * @return 商品列表分页数据
     */
    @RequestMapping("/content-api/searchBikeOfSuf")
    PageInfo<Bike> searchBikeOfSuf(Bike bike);

    /**
     * 查看商品的信息
     *
     * @return 商品信息
     */
    @RequestMapping("/content-api/viewBikeInfo")
    Bike viewBikeInfo(Bike bike);

    @RequestMapping("/content-api/queryBikeList")
    List<Bike> queryBikeList(List<Integer> bikeIdList);
}
