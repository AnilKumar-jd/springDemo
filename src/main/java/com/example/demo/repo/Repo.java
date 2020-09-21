package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;


public interface Repo extends JpaRepository <User,Integer> {

	
	@Query("select u from User u where u.email = ?1 and u.password = ?2")
	User findByEmailAndPassword(String email, String password);
	
	

}

