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

import com.cognixia.jump.model.Admin;
import com.cognixia.jump.repository.AdminRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class AdminController {

	//currently using adminrepository as service. we can change it to AdminService after we create the file.
	
	@Autowired
	AdminRepository service;
	
	
	@CrossOrigin
	@GetMapping("/admins")
	public List<Admin> getAdmins() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable long id) {
		Optional<Admin> newAd = service.findById(id);
		
		if(newAd.isPresent())
			return newAd.get();
		
		return new Admin();
	}
	
	@CrossOrigin
	@PostMapping("/admin/add")
	public void addAdmin(@RequestBody Admin newAdmin) {
		Admin newAd = service.save(newAdmin);
		System.out.println("Added: " + newAd.toString());
		
	}
	
	
	@CrossOrigin
	@PutMapping("/admin/update") 
	public @ResponseBody String updateAdmin(@RequestBody Admin updateAdmin) {
		Optional<Admin> found = service.findById(updateAdmin.getAdmin_id());
		
		if(found.isPresent()) {
			service.save(updateAdmin);
			return "Saved: " + updateAdmin.toString();
		}
		else {
			return "Could not update admin, id doesn't exist.";
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable long id) {
		Optional<Admin> found = service.findById(id);
		if(found.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.status(200).body("Deleted successfully");
		}
		else
		{
			return ResponseEntity.status(400)
					.header("admind id", id + "")
					.body("Admin with id = " + id + " not found");
		}
	}
	
	
}


