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

    private FoodService userService;

    @Autowired
    public void setUserService(FoodService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index()");
        return "redirect:/users";
    }

    // list page
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model) {

        logger.debug("showAllUsers()");
        model.addAttribute("users", userService.findAll());
        return "users/list";

    }


}