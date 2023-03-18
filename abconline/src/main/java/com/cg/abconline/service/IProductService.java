package com.cg.abconline.service;

import java.util.List;

import com.cg.abconline.model.Product;

public interface IProductService {
	
	public Product saveProduct(Product product);
	
	public Product findProductById(int productId);
	
	public List<Product> findAllProducts();

}
