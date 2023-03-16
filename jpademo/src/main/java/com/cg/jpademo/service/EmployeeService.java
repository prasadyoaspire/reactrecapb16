package com.cg.jpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.jpademo.entity.DepartmentEntity;
import com.cg.jpademo.entity.EmployeeEntity;
import com.cg.jpademo.repository.IDepartmentRepository;
import com.cg.jpademo.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Autowired
	private IDepartmentRepository departmentRepository;

	@Transactional
	@Override
	public void addEmployee(EmployeeEntity employeeEntity,int deptId) {
		
		DepartmentEntity departmentEntity = departmentRepository.getDepartmentById(deptId);		
		employeeEntity.setDepartment(departmentEntity);
		
		employeeRepository.saveEmployee(employeeEntity);		
	}

	@Override
	public EmployeeEntity findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
