package com.bike.bikeorder.mapper;

import com.bike.bikecommon.entity.UserCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCartMapper {
    Integer insertUserCart(UserCart userCart);

    Integer deleteUserCartById(UserCart userCart);

    List<UserCart> selectUserCartInfoByUserId(UserCart userCart);

    List<UserCart> selectBikeIdOfUserCartByUserId(UserCart userCart);

    UserCart selectUserCartByBikeId(UserCart userCart);

    List<UserCart> selectUserCartByUserId(Integer userId);
}
