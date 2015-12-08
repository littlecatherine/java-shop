package com.joecui.web.service;

import com.joecui.web.dao.CartDao;
import com.joecui.web.dao.FoodDao;
import com.joecui.web.entity.Cart;
import com.joecui.web.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    CartDao cartDao;
    FoodDao foodDao;

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public Cart findById(Integer id) {
        return cartDao.findById(id);
    }

    @Override
    public Food findByFoodId(Integer id) {
        return foodDao.findById(id);
    }

    @Override
    public String merge(Integer id) {
        System.out.println("Into merge method: ");
        return null;
    }

    @Override
    public List<Cart> findAll() {
        return cartDao.findAll();
    }


}
