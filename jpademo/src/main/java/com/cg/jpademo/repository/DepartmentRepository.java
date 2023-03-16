package com.cg.jpademo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.jpademo.entity.DepartmentEntity;

@Repository
public class DepartmentRepository implements IDepartmentRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveDepartment(DepartmentEntity departmentEntity) {
		entityManager.persist(departmentEntity);	
	}

	@Override
	public DepartmentEntity getDepartmentById(int deptId) {
		DepartmentEntity departmentEntity = entityManager.find(DepartmentEntity.class, deptId);
		return departmentEntity;
	}

	@Override
	public List<DepartmentEntity> getAllDepartments() {
		
		return null;
	}

}
