package com.joecui.web.controller;


import com.joecui.web.entity.Cart;
import com.joecui.web.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joecui.web.service.CatalogueService;
import com.joecui.web.service.CartService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// the old way of representing index page
@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	CartService cartService;
	@Autowired
	CatalogueService catalogueService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/catalogue";
	}

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

	// show cart update form
	@RequestMapping(value = "/cart/{id}/update", method = RequestMethod.GET)
	public String showUpdateCartForm(@PathVariable("id") int id, Model model) {


		Cart cart = cartService.findById(id);
		model.addAttribute("userForm", cart);

		populateDefaultModel(model);

		return "main/updatecart";

	}

	// save or update user
//	@RequestMapping(value = "/users", method = RequestMethod.POST)
//	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
//								   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
//
//		logger.debug("saveOrUpdateUser() : {}", user);
//
//		if (result.hasErrors()) {
//			populateDefaultModel(model);
//			return "users/userform";
//		} else {
//
//			redirectAttributes.addFlashAttribute("css", "success");
//			if(user.isNew()){
//				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
//			}else{
//				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
//			}
//
//			userService.saveOrUpdate(user);
//
//			// POST/REDIRECT/GET
//			return "redirect:/users/" + user.getId();
//
//			// POST/FORWARD/GET
//			// return "user/list";
//
//		}
//
//	}

	private void populateDefaultModel(Model model) {

		List<String> frameworksList = new ArrayList<String>();
		frameworksList.add("Spring MVC");
		frameworksList.add("Struts 2");
		frameworksList.add("JSF 2");
		frameworksList.add("GWT");
		frameworksList.add("Play");
		frameworksList.add("Apache Wicket");
		model.addAttribute("frameworkList", frameworksList);

		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		model.addAttribute("javaSkillList", skill);

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		model.addAttribute("numberList", numbers);

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);

	}

}

