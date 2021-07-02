package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Review;
import com.cognixia.jump.repository.RestaurantRepository;
import com.cognixia.jump.repository.ReviewRepository;
import com.cognixia.jump.repository.UserRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class ReviewController {

	//autowired with repository, can be changed to ReviewService as we add the class. 
	@Autowired
	ReviewRepository service;
	
	@Autowired
	UserRepository u_service;
	
	@Autowired
	RestaurantRepository r_service;
	
	@CrossOrigin
	@GetMapping("/reviews")
	public List<Review> getReviews() {
		return service.findAll();
	}
	
}
