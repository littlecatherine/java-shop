package com.joecui.web.service;

import com.joecui.web.dao.Food1Dao;
import com.joecui.web.entity.Food1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("food1Service")
public class Food1ServiceImpl implements Food1Service {

    Food1Dao food1Dao;

    @Autowired
    public void setFood1Dao(Food1Dao food1Dao) {
        this.food1Dao = food1Dao;
    }

    @Override
    public List<Food1> findAll() {
        return food1Dao.findAll();
    }

}
