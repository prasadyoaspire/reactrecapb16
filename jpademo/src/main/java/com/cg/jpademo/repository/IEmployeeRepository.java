package com.cg.jpademo.repository;

import java.util.List;

import com.cg.jpademo.entity.EmployeeEntity;

public interface IEmployeeRepository {

	public void saveEmployee(EmployeeEntity employeeEntity);
	public EmployeeEntity getEmployeeById(int empId);
	public List<EmployeeEntity> getAllEmployees();
}
