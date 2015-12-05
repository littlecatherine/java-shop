package com.joecui.web.service;

import com.joecui.web.entity.Food;

import java.util.List;

public interface CatalogueService {

    List<Food> findAll();

}