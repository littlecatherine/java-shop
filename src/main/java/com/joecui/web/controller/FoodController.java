package com.joecui.web.controller;

import com.joecui.web.entity.Food;
import com.joecui.web.service.FoodService;

import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import javax.validation.Valid;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@RestController
public class FoodController {

//    private final Logger logger = LoggerFactory.getLogger(FoodController.class);
    @Autowired
    FoodService foodService;

//    private CartService cartService;

//    @Autowired
//    public void setFoodService(FoodService foodService) {
//        this.foodService = foodService;
//    }


    // list page
//    @RequestMapping(value = "/food", method = RequestMethod.GET)
//    public ResponseEntity<List<Food>> listAllFoods() {
//        List<Food> foods = foodService.findAll();
//
//        return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
//
//    }



    // cart page
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String showCart(Model model) {

//        logger.debug("showCart()");
//        model.addAttribute("cartDB", cartService.findAll());
        return "food/cart";

    }

}