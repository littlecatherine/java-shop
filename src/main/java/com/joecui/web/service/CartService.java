package com.joecui.web.service;

import com.joecui.web.entity.Cart;
import com.joecui.web.entity.Food;

import java.util.List;

public interface CartService {

    Cart findById(Integer id);

    Food findByFoodId(Integer id);

    String merge(Integer id);

    List<Cart> findAll();

}