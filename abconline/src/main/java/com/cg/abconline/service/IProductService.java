package com.cg.abconline.service;

import java.util.List;

import com.cg.abconline.entity.ProductEntity;

public interface IProductService {
	
	public ProductEntity saveProduct(ProductEntity productEntity);
	
	public ProductEntity findProductById(int productId);
	
	public List<ProductEntity> findAllProducts();

}
