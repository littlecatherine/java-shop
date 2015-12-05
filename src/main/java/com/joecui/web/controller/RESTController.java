package com.joecui.web.controller;

import com.joecui.web.service.CatalogueService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import javax.validation.Valid;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@RestController
public class RESTController {

//    private final Logger logger = LoggerFactory.getLogger(FoodController.class);
    @Autowired
CatalogueService catalogueService;

//    private CartService cartService;

//    @Autowired
//    public void setFoodService(CatalogueService catalogueService) {
//        this.catalogueService = catalogueService;
//    }


    // list page
//    @RequestMapping(value = "/food", method = RequestMethod.GET)
//    public ResponseEntity<List<Food>> listAllFoods() {
//        List<Food> foods = catalogueService.findAll();
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