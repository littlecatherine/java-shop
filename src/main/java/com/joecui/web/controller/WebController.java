package com.joecui.web.controller;


import com.joecui.web.entity.Cart;
import com.joecui.web.entity.Food;
import com.joecui.web.entity.User;
import com.joecui.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.joecui.web.dao.FoodDao;
import com.joecui.web.dao.CartDao;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

// the old way of representing index page
@Controller
@RequestMapping("/")
public class WebController {

	@Autowired
	CartDao cartDao;
	@Autowired
	FoodDao foodDao;
	@Autowired
	UserDao userDao;

//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(userFormValidator);
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/catalogue";
	}

	@RequestMapping(value = "/catalogue", method = RequestMethod.GET)
	public String showAllFoods(Model model) {
		model.addAttribute("foodsitem", foodDao.findAll());
		return "main/list";
	}

	// save or update user
	@RequestMapping(value = "/catalogue", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
								   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "users/userform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if(user.isNew()){
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

//			userService.saveOrUpdate(user);

			// POST/REDIRECT/GET
			return "redirect:/users/" + user.getId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	// show update form
	@RequestMapping(value = "/catalogue/{id}/add", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

		Food food = foodDao.findById(id);
		model.addAttribute("quantityForm", food);

		populateDefaultModel(model);

		return "main/addquantity";

	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String showCart(Model model) {
		// TODO implement gettotalprice
		model.addAttribute("cartitem", cartDao.findAll());
		System.out.println("before");
		// TODO figure why next line gets bug: at least return a advanced Type rather than Interger or String
		model.addAttribute("www", cartDao.findById(1));
		System.out.println("later");
		// TODO next line works(fetch 1 row), so try add get set totalprice in to cart.java
		System.out.println(cartDao.findById(1));
//		System.out.println(cartDao.getTotalPrice());
		return "main/cart";
//		return null;

	}


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

