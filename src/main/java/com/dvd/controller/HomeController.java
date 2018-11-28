package com.dvd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Defined a class is Controller
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
