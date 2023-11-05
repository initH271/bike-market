package com.bike.bikecommon.client;

import com.bike.bikecommon.entity.UserCart;
import com.bike.bikecommon.entity.UserOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(value = "order-service")
public interface OrderClient {
    /**
     * 查看用户订单信息
     *
     * @param userOrder 用户id和商品id
     * @return 用户订单信息
     */
    @RequestMapping("/order-api/userOrder/viewUserOrderInfo")
    Map<String, Object> viewUserOrderInfo(UserOrder userOrder);

    /**
     * 添加用户订单
     *
     * @param userOrder 用户订单信息
     * @return 用户订单列表
     */
    @RequestMapping("/order-api/userOrder/addUserOrder")
    List<UserOrder> addUserOrder(UserOrder userOrder);

    //
    // 购物车接口
    //

    /**
     * 放一个商品到购物车
     *
     * @param userCart 用户id和商品id
     * @return 购物车列表
     */
    @RequestMapping("/order-api/userCart/putIntoUserCart")
    List<UserCart> putIntoUserCart(UserCart userCart);

    /**
     * 查看购物车
     *
     * @param userCart 用户id
     * @return 购物车列表
     */
    @RequestMapping("/order-api/userCart/viewUserCartInfo")
    List<UserCart> viewUserCartInfo(UserCart userCart);

    /**
     * @param userCart 用户id和商品id
     * @return 购物车列表
     */
    @RequestMapping("/order-api/userCart/deleteUserCart")
    List<UserCart> deleteUserCart(UserCart userCart);
}
