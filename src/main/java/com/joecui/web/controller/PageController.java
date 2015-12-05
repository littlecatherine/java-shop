package com.joecui.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joecui.web.service.FoodService;
import com.joecui.web.service.CartService;

// the old way of representing index page
@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	FoodService foodService;
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public String showAllFoods(Model model) {
		model.addAttribute("foodsitem", foodService.findAll());
		return "food/list";

	}

	@Autowired
	CartService cartService;
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(Model model) {
		model.addAttribute("foodsitem", foodService.findAll());
		model.addAttribute("cartitem", cartService.findAll());
		return "food/newcart";

	}

}

