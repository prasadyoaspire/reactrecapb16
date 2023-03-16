package com.cg.jpademo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.jpademo.entity.ProductEntity;

@Repository
public class ProductRepository implements IProductRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveProduct(ProductEntity productEntity) {
		
		entityManager.persist(productEntity);
	}

	@Override
	public ProductEntity getProductById(int productId) {
		ProductEntity productEntity = entityManager.find(ProductEntity.class, productId);
		return productEntity;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		
		String jpql = "select p from ProductEntity p";
		Query query = entityManager.createQuery(jpql);
		List<ProductEntity> list = query.getResultList();		
		return list;
	}
}
