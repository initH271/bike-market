package com.bike.bikecommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Page {
    public Integer pageNow = 1;  //当前页数
    public Integer pageSizeOfPre = 15; //前端一页的大小
    public Integer pageSizeOfSuf = 8;  //后端一页的大小
}
