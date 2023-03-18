package com.cg.abconline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.abconline.model.Product;
import com.cg.abconline.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@PostMapping("/product/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		return responseEntity;		
	}
	
	@GetMapping("/product/{productId}")
	public  ResponseEntity<Product>  getProduct(@PathVariable("productId") int productId) {
		Product product = productService.findProductById(productId);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/product/all")
	public List<Product> getAllProduct() {
		List<Product> products = productService.findAllProducts();
		return products;
	}
	
	
}
