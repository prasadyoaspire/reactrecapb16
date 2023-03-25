package com.cg.abconline.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.abconline.entity.ProductEntity;
import com.cg.abconline.exception.ResourceNotFoundException;
import com.cg.abconline.model.Product;
import com.cg.abconline.repository.IProductRepository;

@SpringBootTest
class ProductServiceTest {
		
	@InjectMocks
	ProductService productService = new ProductService();;
	
	@Mock
	IProductRepository productRepository;

	@Test
	void findProductByIdTest() {	
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(10);
		productEntity.setProductName("IPhoneY++");
		productEntity.setProductPrice(50000);
		productEntity.setCreatedDate(LocalDate.now());
		productEntity.setCategory("Mobile");
		
		Optional<ProductEntity> optionalProductEntity = Optional.of(productEntity);
		
		when(productRepository.findById(10)).thenReturn(optionalProductEntity);
		
		int productId = 10;		
		Product product = productService.findProductById(productId);
		assertEquals("IPhoneY++",product.getProductName());
		assertEquals(50000,product.getProductPrice());
	}
	
	
	@Test
	void testProductByIdWithException() {
		
		when(productRepository.findById(1020)).thenThrow(ResourceNotFoundException.class);
		
		assertThrows(ResourceNotFoundException.class,()->productService.findProductById(1020));
		
	}
	
	@Test
	void testFindAllProducts() {
		
		ProductEntity productEntity1 = new ProductEntity();
		productEntity1.setProductId(10);
		productEntity1.setProductName("IPhoneX++");
		productEntity1.setProductPrice(50000);
		productEntity1.setCreatedDate(LocalDate.now());
		productEntity1.setCategory("Mobile");
		
		ProductEntity productEntity2 = new ProductEntity();
		productEntity2.setProductId(20);
		productEntity2.setProductName("IPhoneY++");
		productEntity2.setProductPrice(50000);
		productEntity2.setCreatedDate(LocalDate.now());
		productEntity2.setCategory("Mobile");
		
		ProductEntity productEntity3 = new ProductEntity();
		productEntity3.setProductId(30);
		productEntity3.setProductName("IPhoneZ++");
		productEntity3.setProductPrice(50000);
		productEntity3.setCreatedDate(LocalDate.now());
		productEntity3.setCategory("Mobile");
		
		List<ProductEntity> productEntities = new ArrayList<>();
		productEntities.add(productEntity3);
		productEntities.add(productEntity2);
		productEntities.add(productEntity1);
		
		when(productRepository.findAll()).thenReturn(productEntities);
		
		List<Product> products = productService.findAllProducts();
		assertEquals(productEntities.size(),products.size());		
	}	

}
