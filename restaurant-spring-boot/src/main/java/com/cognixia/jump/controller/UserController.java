package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class UserController {

	//currently using repository as service. As we create service, we change this to UserService
	@Autowired
	UserRepository service;
	
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers() {
		return service.findAll();
	}
	
}
