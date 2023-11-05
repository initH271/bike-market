package com.bike.bikecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Bike extends Page {
    private Integer id;
    private String name;
    private String imgPath;
    private Double price;
    private String type;
    private String stockNumber;
    private String saleNumber;

}
