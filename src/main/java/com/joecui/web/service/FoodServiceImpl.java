package com.joecui.web.service;

import com.joecui.web.dao.FoodDao;
import com.joecui.web.entity.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("foodService")
public class FoodServiceImpl implements FoodService {

    FoodDao foodDao;

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public List<Food> findAll() {
//        System.out.print(foodDao.findAll());
        return foodDao.findAll();
    }

}
