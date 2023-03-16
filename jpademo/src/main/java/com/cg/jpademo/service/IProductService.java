package com.cg.jpademo.service;

import java.util.List;

import com.cg.jpademo.entity.ProductEntity;

public interface IProductService {

	public void addProduct(ProductEntity productEntity);
	public ProductEntity findProductById(int productId);
	public List<ProductEntity> findAllProducts();
}
