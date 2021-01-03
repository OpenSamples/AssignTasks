package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.entities.User;
import com.app.services.UserService;

@SpringBootApplication
public class Project implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Project.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User newAdmin = new User("admin@mail.com", "Admin", "123456");
		userService.createAdmin(newAdmin);
		
		// creating new Users with role USER
		User newEmployee1 = new User("pera@gmail.com", "pera", "test123");
		User newEmployee2 = new User("mica@yahoo.com", "mica", "test456");
		User newEmployee3 = new User("djura@outlook.com", "djura", "test789");
		userService.createUser(newEmployee1);
		userService.createUser(newEmployee2);
		userService.createUser(newEmployee3);		
	}
}
