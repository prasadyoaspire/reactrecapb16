package com.cg.abconline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.abconline.model.LoginPayload;
import com.cg.abconline.model.User;
import com.cg.abconline.service.IAuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
	@Autowired
	private IAuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<User> doLogin(@RequestBody LoginPayload payload) {
		User user = authenticationService.login(payload.getUsername(),payload.getPassword());
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

}
