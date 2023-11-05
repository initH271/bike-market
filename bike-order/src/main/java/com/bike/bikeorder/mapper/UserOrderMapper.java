package com.bike.bikeorder.mapper;


import com.bike.bikecommon.entity.User;
import com.bike.bikecommon.entity.UserCart;
import com.bike.bikecommon.entity.UserOrder;
import com.bike.bikecommon.entity.UserOrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOrderMapper {
    User selectUserInfoByUserId(UserOrder userOrder);

    List<UserCart> selectUserCartInfoByUserId(UserOrder userOrder);

    Integer insertUserOrderInfo(UserOrderInfo userOrderInfo);

    Integer insertUserOrder(UserOrder userOrder);

    UserOrderInfo selectUserOrderInfoByCode(UserOrderInfo userOrderInfo);

    List<UserOrder> selectUserOrderList(UserOrder userOrder);

    List<UserOrder> selectUserOrderListByUserId(Integer userId);

    List<UserOrderInfo> selectUserOrderInfoByUserId(Integer userId);
}
