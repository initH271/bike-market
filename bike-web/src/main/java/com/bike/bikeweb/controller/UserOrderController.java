package com.bike.bikeweb.controller;

import com.bike.bikecommon.client.OrderClient;
import com.bike.bikecommon.entity.User;
import com.bike.bikecommon.entity.UserCart;
import com.bike.bikecommon.entity.UserOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userOrder")
public class UserOrderController {

    @Autowired
    OrderClient orderClient;

    /**
     * 获取当前的日期和时间
     */
    public static String getDateTime() {
        Date date = new Date();
        //月份和分钟用大小写区分
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * 获取日期和时间 转换为 字符串
     *
     * @param string 日期和时间
     * @return String 日期时间字符串
     */
    public static String getDateAndTimeToString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if (c == '-' || c == ' ' || c == ':') {
                stringBuilder.deleteCharAt(i);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 查看用户订单信息
     *
     * @param model     存放订单信息
     * @param userOrder 用户id和商品id
     * @return 用户订单界面
     */
    @RequestMapping("ViewUserOrderInfo")
    public ModelAndView ViewUserOrderInfo(ModelAndView model, UserOrder userOrder) {
        Map<String, Object> userOrderInfo = orderClient.viewUserOrderInfo(userOrder);
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.convertValue(userOrderInfo.get("user"), User.class);
        List<UserCart> userCarts = (List<UserCart>) userOrderInfo.get("userCarts");
        model.addObject("user", user);
        model.addObject("userCarts", userCarts);
        model.addObject("sum", UserCartController.countPrice(userCarts));
        model.setViewName("/user/user_order");
        return model;
    }

    @RequestMapping("/addUserOrder")
    public ModelAndView addUserOrder(ModelAndView model, UserOrder userOrder) {
        model.setViewName("/user/user_order_list");
        List<UserOrder> userOrders = orderClient.addUserOrder(userOrder);
        if (userOrders.isEmpty()) {
            model.setViewName("/user/user_cart");
            model.addObject("error", "购物车为空，无法下单！");
            return model;
        }
        model.addObject("userOrders", userOrders);
        return model;
    }
}

