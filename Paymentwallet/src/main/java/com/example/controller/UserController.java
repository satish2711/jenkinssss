package com.example.controller;

import java.util.List;

import com.example.exceptions.IdNotFoundException;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Userdata;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	UserService serviceobj;

	// Add user
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody Userdata u) {
		Userdata e = serviceobj.addUser(u);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	
	// Get all users
	@GetMapping("/GetAllUsers")
	public ResponseEntity<List<Userdata>> getAllUsers() {
		List<Userdata> userlist = serviceobj.getAllUsers();
		return new ResponseEntity<>(userlist, new HttpHeaders(), HttpStatus.OK);

	}
	
	@GetMapping("/getuserbyid/{userId}")
	public ResponseEntity<Userdata> getuserbyid(@PathVariable("userId") int userId)
	{
		Userdata u= serviceobj.getuserbyid(userId);
		return new ResponseEntity<>(u,new HttpHeaders(), HttpStatus.OK);
	}

	//Update User
	@PutMapping("/UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody Userdata u) {
		Userdata e = serviceobj.updateUser(u);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<>("User updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	// Delete User
	@DeleteMapping("/DeleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		serviceobj.deleteUser(userId);
		
			return new ResponseEntity<>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
		
	}

	@PutMapping("/Loginuser")
	public ResponseEntity<String> loginUser(@RequestBody Userdata u)
	{
		
		 boolean flag=serviceobj.loginUser(u);
		if(!flag)
		{
			throw new IdNotFoundException("User not found");
		}else {
			return new ResponseEntity<>("Login successful", new HttpHeaders(), HttpStatus.OK);
		}
	}

}
