package com.joecui.web.service;

import com.joecui.web.dao.CartDao;
import com.joecui.web.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    CartDao cartDao;

    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public List<Cart> findAll() {
        return cartDao.findAll();
    }

}
