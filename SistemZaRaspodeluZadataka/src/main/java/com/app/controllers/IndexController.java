package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "views/loginForm";
	}
	
	@GetMapping("/error")
	 public String getDefaultPage() {
	  return "error";
	 }
}
