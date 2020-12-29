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
		{
			User newAdmin = new User("admin@mail.com", "Admin", "123456");
			userService.createAdmin(newAdmin);
		}
	}
}