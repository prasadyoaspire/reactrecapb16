package com.cg.jpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.jpademo.entity.ProductEntity;
import com.cg.jpademo.repository.IProductRepository;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private IProductRepository productRepository;

	@Transactional
	@Override
	public void addProduct(ProductEntity productEntity) {		
		productRepository.saveProduct(productEntity);		
	}

	@Override
	public ProductEntity findProductById(int productId) {
		ProductEntity productEntity = productRepository.getProductById(productId);
		return productEntity;
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
