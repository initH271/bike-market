package com.bike.bikeorder.service;


import com.bike.bikecommon.entity.UserCart;

import java.util.List;

public interface UserCartService {
    List<UserCart> putIntoUserCart(UserCart userCart);

    List<UserCart> viewUserCartInfo(Integer userId);

    boolean deleteUserCart(UserCart userCart);

}
