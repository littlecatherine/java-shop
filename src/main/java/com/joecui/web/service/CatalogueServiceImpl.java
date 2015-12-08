package com.joecui.web.service;

import com.joecui.web.dao.FoodDao;
import com.joecui.web.entity.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catalogueService")
public class CatalogueServiceImpl implements CatalogueService {

    FoodDao foodDao;

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public Food findById(Integer id) {
        System.out.println("LLL Service");
        return foodDao.findById(id);
    }

    @Override
    public List<Food> findAll() {
        return foodDao.findAll();
    }

}
