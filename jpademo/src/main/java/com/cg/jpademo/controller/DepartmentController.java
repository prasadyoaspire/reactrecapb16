package com.cg.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.jpademo.entity.DepartmentEntity;
import com.cg.jpademo.service.IDepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;
	
	public void save(DepartmentEntity departmentEntity) {
		departmentService.addDepartment(departmentEntity);
		System.out.println("Department saved");
	}
	
	public void getDepartmentDetails(int deptId) {
		DepartmentEntity departmentEntity = departmentService.findDepartmentById(deptId);
		System.out.println("DeptId: "+departmentEntity.getDeptId());
		System.out.println("DeptName: "+departmentEntity.getDeptName());
		
	}	
}
