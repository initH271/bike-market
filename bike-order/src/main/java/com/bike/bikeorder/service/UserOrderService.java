package com.bike.bikeorder.service;


import com.bike.bikecommon.entity.User;
import com.bike.bikecommon.entity.UserCart;
import com.bike.bikecommon.entity.UserOrder;

import java.util.List;

public interface UserOrderService {
    User viewUserOrderInfoOfUser(UserOrder userOrder);

    List<UserCart> viewUserOrderInfoOfCart(UserOrder userOrder);

    List<UserOrder> addUserOrderInfo(UserOrder userOrder);
}
