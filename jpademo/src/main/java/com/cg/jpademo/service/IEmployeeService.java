package com.cg.jpademo.service;

import java.util.List;

import com.cg.jpademo.entity.EmployeeEntity;

public interface IEmployeeService {

	public void addEmployee(EmployeeEntity employeeEntity,int deptId);
	public EmployeeEntity findEmployeeById(int empId);
	public List<EmployeeEntity> findAllEmployees();
}
