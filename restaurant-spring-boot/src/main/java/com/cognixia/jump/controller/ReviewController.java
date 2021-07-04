package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//finds a specific review by id
	@CrossOrigin
	@GetMapping("/review/{id}")
	public Review getReview(@PathVariable long id) {
		Optional<Review> result = service.findById(id);
		if(result.isPresent())
			return result.get();
		
		return new Review();
		
	}
	
	
//	@CrossOrigin
//	@PostMapping("/review/add/{user_id}/{restaurant_id}")
//	public void addReview(@)
	
	
	@CrossOrigin
	@PutMapping("/review/update")
	public @ResponseBody String updateReview(@RequestBody Review review) {
		Optional<Review> found = service.findById(review.getReview_id());
		
		if(found.isPresent()) {
			service.save(review);
			return "review edited";
		}
		else {
			return "Coudn't edit ithe review";
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/review/delete/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		
		Optional<Review> found = service.findById(id);
		
		if(found.isPresent()) {
			
			service.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted review with id = " + id);	
		}
		else {
			return ResponseEntity.status(400)
					.header("review id", id + "")
					.body("Review with id = " + id + " not found");
		}
			
	}
	
}
