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
//        System.out.println("LLL Service");
//        System.out.println(foodDao.findById(id));
//        return cartDao.findById(id);
        return cartDao.findById(id);
    }

    @Override
    public Food findByFoodId(Integer id) {
        return foodDao.findById(id);
    }

    @Override
    public String merge(Integer id) {
        System.out.println("Into merge method: ");
//        System.out.println(cartDao.findById(id));
//        System.out.println("cartDao: pass");
//        String cart = String.valueOf(cartDao.findById(id));
//        String food = String.valueOf(foodDao.findById(id));
//        System.out.println("cart food: pass");
//        String sum = cart + food;
//        System.out.println("merge-sum: "+sum);



//        Cart c = new Cart();
//        Integer a = c.getFood_id();
//        c.getQuantity();
//        System.out.println("ID= " + a);

        return null;
    }

//    @Override
//    public Cart merge() {
//
//        String ok = foodDao.findById(id);
//        System.out.println(ok);
//        return ok;
//    }

    @Override
    public List<Cart> findAll() {
        return cartDao.findAll();
    }


}
