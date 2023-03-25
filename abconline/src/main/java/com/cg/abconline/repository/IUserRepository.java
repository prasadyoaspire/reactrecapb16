package com.cg.abconline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.abconline.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity,Integer>{

}
