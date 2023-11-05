package com.bike.bikecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserOrder extends Page {
    private Integer id;
    private Integer userId;
    private Integer bikeId;
    private Integer userOrderInfoId;
    private User user;
    private Bike bike;
    private UserOrderInfo userOrderInfo;
}
