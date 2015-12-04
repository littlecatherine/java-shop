package com.joecui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joecui.web.entity.Food;
import com.joecui.web.service.FoodService;


// the old way of representing index page
@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	FoodService foodService;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
	        return "food/oldlist";
	    }

	// list page
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public String showAllFoods(Model model) {
		model.addAttribute("foods", foodService.findAll());
		return "food/list";

	}

}

