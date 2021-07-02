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
	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurants() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/restaurant/{id}")
	public Restaurant getRestaurant(@PathVariable long id) {
		Optional<Restaurant> newRes = service.findById(id);
		
		if(newRes.isPresent())
			return newRes.get();
		
		return new Restaurant();
	}
	
	@CrossOrigin
	@PutMapping("/restaurant/update")
	public @ResponseBody String updateRestaurant(@RequestBody Restaurant updateRestaurant) {
		
		Optional<Restaurant> found = service.findById(updateRestaurant.getRestaruant_id());
		
		if(found.isPresent()) {
			service.save(updateRestaurant);
			return "Saved: " + updateRestaurant.toString();
		}
		else {
			return "update failed: id doesn't exist.";
		}
		
	}
	
	@CrossOrigin
	@DeleteMapping("/restaurant/delete")
	public ResponseEntity<String> deleteRestaurant(@PathVariable long id) {
		Optional<Restaurant> found = service.findById(id);
		
		if(found.isPresent()) {
			service.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted Restaurant");		
		}
		else {
			return ResponseEntity.status(400)
					.header("restaurant id", id + "")
					.body("Restaurant with id = " + id + " not found");
		}
	}
}
