package com.joecui.web.controller;

import com.joecui.web.service.FoodService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import javax.validation.Valid;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@Controller
public class FoodController {

    private final Logger logger = LoggerFactory.getLogger(FoodController.class);

    private FoodService foodService;

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index()");
        return "redirect:/food";
    }

    // list page
    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public String showAllFoods(Model model) {

        logger.debug("showAllFoods()");
        model.addAttribute("foods", foodService.findAll());
        return "food/list";

    }


}