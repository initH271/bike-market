package com.bike.bikecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserCart extends Page {
    private Integer id;
    private Integer userId;
    private Integer bikeId;
    private Bike bike;
}
