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
        // it will output User [id=100, name=mkyong, email=mkyong@gmail.com, address=null, password=null, confirmPassword=null, newsletter=false, framework=[Spring MVC,  GWT], sex=null, number=0, country=null, skill=[]]false
        System.out.println("LLL Service");
//        System.out.println(foodDao.findById(id));
        return foodDao.findById(id);
    }

    @Override
    public List<Food> findAll() {
//        System.out.print(foodDao.findAll());
        return foodDao.findAll();
    }

}
