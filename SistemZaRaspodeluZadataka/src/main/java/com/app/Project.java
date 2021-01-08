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
		User newAdmin = new User("admin@mail.com", "Pera Admin", "123456");
		userService.createAdmin(newAdmin);
		
		// creating new Users with role USER
		User newEmployee1 = new User("pera@gmail.com", "Petar Peric", "test123");
		User newEmployee2 = new User("mica@yahoo.com", "Milica Milic", "test456");
		User newEmployee3 = new User("djura@outlook.com", "Djura Djuric", "test789");
		userService.createUser(newEmployee1);
		userService.createUser(newEmployee2);
		userService.createUser(newEmployee3);		
	}
}
