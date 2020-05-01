package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.entity.Userdata;


@Repository
public interface UserDao extends JpaRepository<Userdata, Integer> {
	
	
}
