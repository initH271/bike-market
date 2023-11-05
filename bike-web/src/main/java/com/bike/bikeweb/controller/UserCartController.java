package com.bike.bikeweb.controller;

import com.bike.bikecommon.client.OrderClient;
import com.bike.bikecommon.entity.UserCart;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/userCart")
public class UserCartController {
    @Autowired
    OrderClient orderClient;

    /**
     * 计算总价
     *
     * @param userCarts 购物车中所有物品
     * @return 总价
     */
    public static double countPrice(List<UserCart> userCarts) {
        double sum = 0;
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < userCarts.size(); i++) {
            sum += objectMapper.convertValue(userCarts.get(i), UserCart.class).getBike().getPrice();
        }
        BigDecimal bigDecimal = new BigDecimal(sum);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 放一个商品到购物车
     *
     * @param session
     * @param model
     * @param userCart
     * @return
     */
    @RequestMapping("/putIntoUserCart")
    public ModelAndView putIntoUserCart(HttpSession session, ModelAndView model, UserCart userCart) {
        if (session.getAttribute("user") != null) {
            List<UserCart> userCartsInMysql = orderClient.putIntoUserCart(userCart);
            System.out.println(userCart);
            model.addObject("userCarts", userCartsInMysql);
            model.addObject("sum", countPrice(userCartsInMysql));
            model.setViewName("/user/user_cart");
        } else {
            model.setViewName("/user/sign_in");
        }
        return model;
    }

    @RequestMapping("/viewUserCartInfo")
    public ModelAndView viewUserCartInfo(ModelAndView model, UserCart userCart) {
        List<UserCart> userCartsInMysql = orderClient.viewUserCartInfo(userCart);
        model.addObject("userCarts", userCartsInMysql);
        model.addObject("sum", countPrice(userCartsInMysql));
        model.setViewName("/user/user_cart");
        return model;
    }

    @RequestMapping("/deleteUserCart")
    public ModelAndView deleteUserCart(ModelAndView model, UserCart userCart) {
        List<UserCart> userCartsInMysql = orderClient.deleteUserCart(userCart);
        model.addObject("userCarts", userCartsInMysql);
        model.addObject("sum", countPrice(userCartsInMysql));
        model.setViewName("/user/user_cart");
        return model;
    }

}
