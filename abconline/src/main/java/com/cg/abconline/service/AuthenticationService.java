package com.cg.abconline.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.abconline.entity.UserAccountEntity;
import com.cg.abconline.entity.UserEntity;
import com.cg.abconline.exception.ResourceNotFoundException;
import com.cg.abconline.model.User;
import com.cg.abconline.repository.IUserAccountRepository;
import com.cg.abconline.repository.IUserRepository;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private IUserAccountRepository userAccountRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User login(String username, String password) {
		
		Optional<UserAccountEntity> optionalUserAccount = userAccountRepository.findByUsername(username);
		if(optionalUserAccount.isEmpty()) {
			throw new ResourceNotFoundException("Username not existing");
		}
		UserAccountEntity userAccount = optionalUserAccount.get();
		
		if(!userAccount.getPassword().equals(password)) {
			throw new ResourceNotFoundException("Invalid login");
		}
		UserEntity userEntity = userRepository.findById(userAccount.getUserId()).get();
		
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setRole(userAccount.getRole());
		
		return user;
	
	}

}
