package com.cg.abconline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.abconline.entity.ProductEntity;
import com.cg.abconline.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@PostMapping("/product/save")
	public ProductEntity addProduct(@RequestBody ProductEntity productEntity) {
		ProductEntity newProductEntity = productService.saveProduct(productEntity);
		return newProductEntity;		
	}
}
