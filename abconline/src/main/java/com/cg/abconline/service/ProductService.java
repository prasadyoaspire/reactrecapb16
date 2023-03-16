package com.cg.abconline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.abconline.entity.ProductEntity;
import com.cg.abconline.exception.ResourceNotFoundException;
import com.cg.abconline.repository.IProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		ProductEntity newProductEntity = productRepository.save(productEntity);
		return newProductEntity;
	}

	@Override
	public ProductEntity findProductById(int productId) {
		Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: "+productId);
		}
		ProductEntity productEntity = optionalProduct.get();
		return productEntity;
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
}
