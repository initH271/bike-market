package com.bike.bikeorder.service.impl;

import com.bike.bikecommon.client.ContentClient;
import com.bike.bikecommon.client.UserClient;
import com.bike.bikecommon.entity.*;
import com.bike.bikeorder.mapper.UserCartMapper;
import com.bike.bikeorder.mapper.UserOrderMapper;
import com.bike.bikeorder.service.UserCartService;
import com.bike.bikeorder.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.bike.bikeorder.controller.UserOrderController.getDateAndTimeToString;
import static com.bike.bikeorder.controller.UserOrderController.getDateTime;


@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserCartMapper userCartMapper;

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    UserClient userClient;

    @Autowired
    UserCartService userCartService;

    @Autowired
    ContentClient bikeClient;

    public User viewUserOrderInfoOfUser(UserOrder userOrder) {
        User user = new User();
        user.setId(userOrder.getUserId());
        user = userClient.userViewPersInfo(user);
        return user;
    }

    public List<UserCart> viewUserOrderInfoOfCart(UserOrder userOrder) {
        return userCartService.viewUserCartInfo(userOrder.getUserId());
    }

    public List<UserOrder> addUserOrderInfo(UserOrder userOrder) {
        //添加用户订单基本信息
        UserOrderInfo userOrderInfo = new UserOrderInfo();
        String dateTime = getDateTime();
        userOrderInfo.setDateTime(dateTime);
        userOrderInfo.setCode(getDateAndTimeToString(dateTime));
        userOrderInfo.setStatus("待付款");
        userOrderMapper.insertUserOrderInfo(userOrderInfo);
        //获取用户订单的id
        Integer id = userOrderMapper.selectUserOrderInfoByCode(userOrderInfo).getId();
        //获取用户购物车列表
        UserCart userCart = new UserCart();
        userCart.setUserId(userOrder.getUserId());
        List<UserCart> userCarts = userCartMapper.selectBikeIdOfUserCartByUserId(userCart);
        if (userCarts.isEmpty()) { // 如果用户购物车为空，直接返回
            return new ArrayList<>();
        }
        //循环添加用户订单信息
        for (UserCart userCartInMysql : userCarts) {
            Integer bikeId = userCartInMysql.getBikeId();
            userOrder.setBikeId(bikeId);
            userOrder.setUserOrderInfoId(id);
            userOrderMapper.insertUserOrder(userOrder);
        }
        //获取用户订单列表
        List<UserOrder> userOrderList = userOrderMapper.selectUserOrderListByUserId(userOrder.getUserId());
        // 1. 根据用户id获取到所有的用户订单信息id
        List<UserOrderInfo> userOrderInfos = userOrderMapper.selectUserOrderInfoByUserId(userOrder.getUserId());
        // 2. 根据bikeId获取到所有的商品信息
        List<Integer> bikeIds = new ArrayList<>();
        for (UserOrder uo : userOrderList) {
            bikeIds.add(uo.getBikeId());
        }
        List<Bike> bikes = bikeClient.queryBikeList(bikeIds);
        // 3. 装载数据
        userOrderList.forEach(uo -> {
            bikes.forEach(bike -> {
                if (uo.getBikeId().equals(bike.getId())) {
                    uo.setBike(bike);
                }
            });
            userOrderInfos.forEach(uoi -> {
                if (uo.getUserOrderInfoId().equals(uoi.getId())) {
                    uo.setUserOrderInfo(uoi);
                }
            });
        });


        return userOrderList;
    }
}
