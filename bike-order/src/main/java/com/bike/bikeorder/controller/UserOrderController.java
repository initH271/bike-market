package com.bike.bikeorder.controller;

import com.bike.bikecommon.entity.User;
import com.bike.bikecommon.entity.UserCart;
import com.bike.bikecommon.entity.UserOrder;
import com.bike.bikeorder.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order-api/userOrder")
public class UserOrderController {

    /**
     * 用户订单服务
     */
    @Autowired
    UserOrderService userOrderService;

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
     * @param userOrder 用户id和商品id
     * @return 用户订单界面
     */
    @RequestMapping("/viewUserOrderInfo")
    public Map<String, Object> ViewUserOrderInfo(@RequestBody UserOrder userOrder) {
        Map<String, Object> map = new HashMap<>();
        User user = userOrderService.viewUserOrderInfoOfUser(userOrder);
        List<UserCart> userCarts = userOrderService.viewUserOrderInfoOfCart(userOrder);
        map.put("user", user);
        map.put("userCarts", userCarts);
        map.put("sum", UserCartController.countPrice(userCarts));
        return map;
    }

    @RequestMapping("/addUserOrder")
    public List<UserOrder> addUserOrder(@RequestBody UserOrder userOrder) {
        System.out.println(userOrder.getUserId());
        List<UserOrder> userOrders = userOrderService.addUserOrderInfo(userOrder);
        return userOrders;
    }
}
