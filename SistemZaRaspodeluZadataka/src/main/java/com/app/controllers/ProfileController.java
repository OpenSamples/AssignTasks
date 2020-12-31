package com.app.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.entities.User;
import com.app.services.TaskService;
import com.app.services.UserService;

@Controller
public class ProfileController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		String email = principal.getName();
		User user = userService.findOne(email);
		
		model.addAttribute("task", taskService.findUserTask(user));
		
		return "views/profile";
	}
}
