package com.cg.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.jpademo.entity.EmployeeEntity;
import com.cg.jpademo.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	public void save(EmployeeEntity employeeEntity, int deptId) {
		employeeService.addEmployee(employeeEntity,deptId);
		System.out.println("Employee saved");
	}
	
	public void getEmployeeDetails(int empId) {
		EmployeeEntity employeeEntity = employeeService.findEmployeeById(empId);
		System.out.println("EmpId: "+employeeEntity.getEmpId());
		System.out.println("Name: "+employeeEntity.getEmpName());
		System.out.println("Salary: "+employeeEntity.getSalary());
		System.out.println("Email: "+employeeEntity.getEmail());
		System.out.println("Mobile: "+employeeEntity.getMobile());
		
	}	
}
