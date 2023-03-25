package com.cg.abconline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.abconline.entity.UserAccountEntity;
import com.cg.abconline.entity.UserEntity;
import com.cg.abconline.model.User;
import com.cg.abconline.repository.IUserAccountRepository;

@Service
public class UserService implements IUserService {	
	
	@Autowired
	private IUserAccountRepository userAccountRepository;
	
	@Override
	public User saveUser(User user) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEmail(user.getEmail());
		userEntity.setMobile(user.getMobile());
		
		UserAccountEntity userAccountEntity = new UserAccountEntity();
		userAccountEntity.setUsername(user.getUsername());
		userAccountEntity.setPassword(user.getPassword());
		userAccountEntity.setRole(user.getRole());
		
		userAccountEntity.setUser(userEntity);		
		
		userAccountEntity = userAccountRepository.save(userAccountEntity);
		
		user.setUserId(userAccountEntity.getUserId());
		
		return user;
	}
}
