package com.joecui.web.controller;


import com.joecui.web.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joecui.web.service.CatalogueService;
import com.joecui.web.service.CartService;

// the old way of representing index page
@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	CartService cartService;
	@Autowired
	CatalogueService catalogueService;

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public String showAllFoods(Model model) {
		model.addAttribute("foodsitem", catalogueService.findAll());
//		System.out.println(cartService.findAll());
		return "main/list";
//		return null;

	}

	@RequestMapping(value = "/catalogue/{id}", method = RequestMethod.GET)
	public String showFood(@PathVariable("id") int id, Model model) {

		model.addAttribute("foodsitem", catalogueService.findById(id));
		return "main/list";
//		return null;

	}


	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(Model model) {
		// TODO implement gettotalprice
		model.addAttribute("cartitem", cartService.findAll());
		System.out.println("before");
		// TODO figure why next line gets bug: at least return a advanced Type rather than Interger or String
		model.addAttribute("www", cartService.findById(1));
		System.out.println("later");
		// TODO next line works(fetch 1 row), so try add get set totalprice in to cart.java
		System.out.println(cartService.findById(1));
//		System.out.println(cartService.getTotalPrice());
		return "main/cart";
//		return null;

	}

	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public String showCartById(@PathVariable("id") int id, Model model) {

		model.addAttribute("cartitem", cartService.findById(id));
		return "main/list";
//		return null;

	}

}

