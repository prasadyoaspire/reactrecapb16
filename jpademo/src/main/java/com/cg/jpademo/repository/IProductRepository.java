package com.cg.jpademo.repository;

import java.util.List;

import com.cg.jpademo.entity.ProductEntity;

public interface IProductRepository {
	public void saveProduct(ProductEntity productEntity);
	public ProductEntity getProductById(int productId);
	public List<ProductEntity> getAllProducts();
}
