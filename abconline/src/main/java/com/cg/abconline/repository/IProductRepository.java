package com.cg.abconline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.abconline.entity.ProductEntity;

public interface IProductRepository extends JpaRepository<ProductEntity,Integer>{

}
