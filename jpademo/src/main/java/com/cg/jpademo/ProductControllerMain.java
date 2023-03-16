package com.cg.jpademo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.jpademo.controller.ProductController;
import com.cg.jpademo.entity.ProductEntity;

public class ProductControllerMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		
		ProductController productController = context.getBean(ProductController.class);
		
		//ProductController productController = new 	ProductController();
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(20);
		productEntity.setProductName("IPhoneZ++");
		productEntity.setProductPrice(44000);
		productEntity.setCategory("Mobile");
		
		productController.save(productEntity);
		
		context.close();
		

	}

}
