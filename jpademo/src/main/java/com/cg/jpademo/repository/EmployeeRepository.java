package com.cg.jpademo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.jpademo.entity.EmployeeEntity;

@Repository
public class EmployeeRepository implements IEmployeeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveEmployee(EmployeeEntity employeeEntity) {
		
		entityManager.persist(employeeEntity);
	}

	@Override
	public EmployeeEntity getEmployeeById(int empId) {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, empId);
		return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
