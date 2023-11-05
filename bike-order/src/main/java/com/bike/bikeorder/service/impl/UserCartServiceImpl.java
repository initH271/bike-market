package com.bike.bikeorder.service.impl;

import com.bike.bikecommon.client.ContentClient;
import com.bike.bikecommon.entity.Bike;
import com.bike.bikecommon.entity.UserCart;
import com.bike.bikeorder.mapper.UserCartMapper;
import com.bike.bikeorder.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    private UserCartMapper userCartMapper;

    @Autowired
    private ContentClient bikeContent;

    public List<UserCart> putIntoUserCart(UserCart userCart) {
        if (userCartMapper.selectUserCartByBikeId(userCart) == null) {
            userCartMapper.insertUserCart(userCart);
        }
        return this.viewUserCartInfo(userCart.getUserId());
    }

    public List<UserCart> viewUserCartInfo(Integer userId) {
        // 1. 查到所有购物车中的商品id
        List<UserCart> userCarts = userCartMapper.selectUserCartByUserId(userId);
        // Q: 将userCarts中所有的bikeId取出来变成List<Integer> bikeIds, 给出代码
        // A:
        List<Integer> bikeIds = new ArrayList<>();
        userCarts.forEach(userCart1 -> bikeIds.add(userCart1.getBikeId()));
        // 2. 根据商品id查到商品信息, content-api
        List<Bike> bikes = bikeContent.queryBikeList(bikeIds);
        // 3. 将商品信息和购物车信息合并
        userCarts.forEach(userCart1 -> {
            bikes.forEach(bike -> {
                if (userCart1.getBikeId().equals(bike.getId())) {
                    userCart1.setBike(bike);
                }
            });
        });
        return userCarts;
    }

    public boolean deleteUserCart(UserCart userCart) {
        Integer rows = userCartMapper.deleteUserCartById(userCart);
        return rows > 0;
    }
}
