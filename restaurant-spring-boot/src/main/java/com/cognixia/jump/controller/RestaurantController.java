package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.repository.RestaurantRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class RestaurantController {

	//Currently autowired with repository. change it to service as you create the class. 
	@Autowired
	RestaurantRepository service;
	
	@CrossOrigin
	@GetMapping("/admins")
	public List<Restaurant> getRestaurants() {
		return service.findAll();
	}
}
