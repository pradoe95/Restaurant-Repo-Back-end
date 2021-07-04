package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@CrossOrigin
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable long id) {
		Optional<User> resultUser = service.findById(id);
		if(resultUser.isPresent()) {
			return resultUser.get();
		}
		return new User();
	}
	
	
	@CrossOrigin
	@PostMapping("/user/signup") 
	public void signupUser(@RequestBody User newUser){
		User added = service.save(newUser);
		
		System.out.println("new user: " + added + " added");
		
	}
	
	@CrossOrigin
	@PutMapping("/user/update")
	public @ResponseBody String updateUser(@RequestBody User user) {
		
		Optional<User> found = service.findById(user.getUser_id());
		if(found.isPresent()) {
			service.save(user);
			return "updated: " + user.toString();
		} 
		else {
			return "Couldn't update the user. User does not exist";
		}
		
	}
	
	@CrossOrigin
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		
		Optional<User> found = service.findById(id);
		if(found.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.status(200).body("deleted sufully");
		}
		else {
			return ResponseEntity.status(400)
					.header("user id", id + "")
					.body("user with id = " + id + " not found");
		}
		
	}
	
	
	
}
