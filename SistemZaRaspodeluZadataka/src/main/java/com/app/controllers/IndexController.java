package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class IndexController {

	@GetMapping({"/", "/index"})
	public String showIndexPage(Model model) {
		model.addAttribute("name", "John");
		return "index";
	}
}
