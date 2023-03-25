package com.cg.abconline.service;

import com.cg.abconline.model.User;

public interface IAuthenticationService {

	public User login(String username,String password);
}
