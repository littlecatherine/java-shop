package com.joecui.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//import com.joecui.web.service.FoodService;
import com.joecui.web.service.Food1Service;

// the old way of representing index page
@Controller
//@RequestMapping("/")
public class PageController {

	@Autowired
//	FoodService foodService;
	Food1Service food1Service;

//	@RequestMapping(method = RequestMethod.GET)
//	public String getIndexPage() {
//	        return "food/oldlist";
//	    }

	// list page
//	@RequestMapping(value = "/food", method = RequestMethod.GET)
//	public String showAllFoods(Model model) {
//		model.addAttribute("foods", foodService.findAll());
//		return "food/list";
//
//	}

	// food1 page
	@RequestMapping(value = "/food1", method = RequestMethod.GET)
	public String showCart(Model model) {
		model.addAttribute("food1", food1Service.findAll());
		return "food/newlist";

	}

}

