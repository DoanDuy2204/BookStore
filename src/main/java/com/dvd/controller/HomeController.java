package com.dvd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvd.DAO.ProductDao;
import com.dvd.entity.Product;

//Defined a class is Controller
@Controller
public class HomeController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);
		return "list-product";
	}
}
