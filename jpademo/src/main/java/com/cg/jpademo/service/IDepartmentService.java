package com.cg.jpademo.service;

import java.util.List;

import com.cg.jpademo.entity.DepartmentEntity;

public interface IDepartmentService {

	public void addDepartment(DepartmentEntity departmentEntity);
	public DepartmentEntity findDepartmentById(int deptId);
	public List<DepartmentEntity> findAllDepartments();
}
