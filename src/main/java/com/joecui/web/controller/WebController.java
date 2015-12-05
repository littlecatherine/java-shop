package com.joecui.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joecui.web.service.CatalogueService;
import com.joecui.web.service.CartService;

// the old way of representing index page
@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	CatalogueService catalogueService;
	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public String showAllFoods(Model model) {
		model.addAttribute("foodsitem", catalogueService.findAll());
		return "main/list";

	}

	@Autowired
	CartService cartService;
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(Model model) {
		model.addAttribute("foodsitem", catalogueService.findAll());
		model.addAttribute("cartitem", cartService.findAll());
		return "main/cart";

	}

}

