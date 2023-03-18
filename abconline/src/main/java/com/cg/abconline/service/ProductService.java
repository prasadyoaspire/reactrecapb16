package com.cg.abconline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.abconline.entity.ProductEntity;
import com.cg.abconline.exception.ResourceNotFoundException;
import com.cg.abconline.model.Product;
import com.cg.abconline.repository.IProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {

		// convert product model to product entity
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(product, productEntity);

		ProductEntity newProductEntity = productRepository.save(productEntity);

		// convert product entity to product model
		Product newProduct = new Product();
		BeanUtils.copyProperties(newProductEntity, newProduct);

		return newProduct;
	}

	@Override
	public Product findProductById(int productId) {
		Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: " + productId);
		}
		ProductEntity productEntity = optionalProduct.get();

		// convert product entity to product model
		Product product = new Product();
		BeanUtils.copyProperties(productEntity, product);

		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		 
		List<ProductEntity> productEntities = productRepository.findAll();
		
		//convert product entity list to product list
		List<Product> products = new ArrayList<>();
		
		productEntities.forEach(pentity-> {
			Product product = new Product();
			BeanUtils.copyProperties(pentity, product);
			products.add(product);
		});		
		
		return products;
	}
}
