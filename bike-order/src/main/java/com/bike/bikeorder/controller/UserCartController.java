package com.bike.bikeorder.controller;

import com.bike.bikecommon.entity.UserCart;
import com.bike.bikeorder.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order-api/userCart")
public class UserCartController {

    @Autowired
    UserCartService userCartService;

    /**
     * 计算总价
     *
     * @param userCarts 购物车中所有物品
     * @return 总价
     */
    public static double countPrice(List<UserCart> userCarts) {
        double sum = 0;
        for (UserCart userCart : userCarts) {
            sum += userCart.getBike().getPrice();
        }
        BigDecimal bigDecimal = new BigDecimal(sum);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 放一个商品到购物车
     *
     * @param session
     * @param userCart
     * @return
     */
    @RequestMapping("/putIntoUserCart")
    public List<UserCart> putIntoUserCart(@RequestBody UserCart userCart) {
        List<UserCart> userCarts = userCartService.putIntoUserCart(userCart);
        if (userCarts == null) {
            userCarts = new ArrayList<>();
        }
        return userCarts;
    }

    /**
     * 查看购物车
     *
     * @param userCart
     * @return
     */
    @RequestMapping("/viewUserCartInfo")
    public List<UserCart> viewUserCartInfo(@RequestBody UserCart userCart) {
        return userCartService.viewUserCartInfo(userCart.getUserId());
    }

    /**
     * @param userCart
     * @return
     */
    @RequestMapping("/deleteUserCart")
    public List<UserCart> deleteUserCart(@RequestBody UserCart userCart) {
        userCartService.deleteUserCart(userCart);
        return userCartService.viewUserCartInfo(userCart.getUserId());
    }
}