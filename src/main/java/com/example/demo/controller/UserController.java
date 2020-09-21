package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repo.Repo;


@CrossOrigin(origins="*")
@RequestMapping("/user")
@RestController

public class UserController {
	
	@Autowired
	 Repo repo;    
	
	
	@PostMapping("/login")
	public String getUser( @RequestBody User user) {

		
		User validUser=repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(validUser!=null)
		{
			return "Login Successfull";
		}		
		else {
			return "Invalid Details";
		}
	}
	
	@PostMapping("/signup")
	public String addUser(@RequestBody User user) {
		
		try {repo.save(user);
		return "Successfully Register";}
         
		catch(Exception e){
			e.printStackTrace();

			return "the email is already registered";
			
		}
		
	}
	
	@GetMapping("/hello")
	public String Hello( ) {
		return "hello from demo apnabazar";
	}

}
