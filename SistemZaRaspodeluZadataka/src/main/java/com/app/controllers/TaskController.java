package com.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entities.Task;
import com.app.entities.User;
import com.app.services.TaskService;
import com.app.services.UserService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserService userService;

	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session) {
		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		return "views/taskForm";
	}

	@RequestMapping("/tasks/{userEmail}")
	public String showUserTasks(Model model, @PathVariable String userEmail) {
		User user = userService.findOne(userEmail);
		if (user != null) {
			List<Task> userTasks = taskService.findAllTasksByUser(userEmail);
			model.addAttribute("tasks", userTasks);
			model.addAttribute("user", user);
			return "views/userTasks";
		}
		return "views/list";
	}

	@PostMapping("/addTask")
	public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "views/taskForm";
		}
		String email = (String) session.getAttribute("email");
		taskService.addTask(task, userService.findOne(email));

		return "redirect:/users";
	}

	@GetMapping("/updateTask/{taskId}")
	public String goToUpdateTask(@PathVariable("taskId") Long taskId, Model model,
			@Valid Task task, BindingResult bindingResult, HttpSession seesion) {		
		model.addAttribute("task", taskService.findTaskById(taskId));
		return "views/taskForm";
	}

	@GetMapping("/deleteTask/{taskId}")
	public String deleteTask(@PathVariable("taskId") Long taskId, Model model) {
		Task task = taskService.findTaskById(taskId);
		if (task != null) {
			taskService.deleteTask(task);
			return "redirect:/tasks/" + task.getUser().getEmail();
		} else {
			model.addAttribute("errorMessage", true);
		}
		return "views/userTasks";
	}

}
