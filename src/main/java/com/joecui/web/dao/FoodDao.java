package com.joecui.web.dao;

import com.joecui.web.entity.Food;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FoodDao {


	List<Food> findAll();

	Food findById(Integer id);

}