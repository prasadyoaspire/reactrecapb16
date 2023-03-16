package com.cg.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.jpademo.entity.ProductEntity;
import com.cg.jpademo.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	
	public void save(ProductEntity productEntity) {
		productService.addProduct(productEntity);
		System.out.println("Product saved.");
	}
	
	public void getProductDetails(int productId) {
		ProductEntity productEntity = productService.findProductById(productId);
		System.out.println("Id: "+productEntity.getProductId());
		System.out.println("Name: "+productEntity.getProductName());
		System.out.println("Price: "+productEntity.getProductPrice());
		System.out.println("Category: "+productEntity.getCategory());				
	}
	
	
}
