package com.cg.abconline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.abconline.entity.UserAccountEntity;

public interface IUserAccountRepository extends JpaRepository<UserAccountEntity,Integer>{
	
	Optional<UserAccountEntity> findByUsername(String username);
}
