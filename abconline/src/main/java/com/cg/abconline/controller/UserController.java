package com.cg.abconline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.abconline.model.User;
import com.cg.abconline.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		user = userService.saveUser(user);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
}
