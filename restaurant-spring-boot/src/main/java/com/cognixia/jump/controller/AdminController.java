package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Admin;
import com.cognixia.jump.repository.AdminRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class AdminController {

	//currently using adminrepository as service. we can change it to AdminService after we create the file.
	
	@Autowired
	AdminRepository service;
	
	public List<Admin> getAdmins() {
		return service.findAll();
	}
}
