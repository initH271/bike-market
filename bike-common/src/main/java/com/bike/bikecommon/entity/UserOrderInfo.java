package com.bike.bikecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserOrderInfo {
    private Integer id;
    private String dateTime;
    private String code;
    private String status;
}
