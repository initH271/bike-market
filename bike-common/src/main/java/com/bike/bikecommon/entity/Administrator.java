package com.bike.bikecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Administrator extends Page {
    private Integer id;
    private String account;
    private String password;
    private String nickname;
    private String name;
    private String phone;
}
