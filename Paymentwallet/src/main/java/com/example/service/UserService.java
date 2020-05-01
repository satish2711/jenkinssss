package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Userdata;


@Component
public interface UserService {

	Userdata addUser(Userdata u);
	
	List<Userdata> getAllUsers();

	void deleteUser(int userId);

	Userdata updateUser(Userdata u);
	
	Boolean loginUser(Userdata u);
	Userdata getuserbyid(int userId);

}