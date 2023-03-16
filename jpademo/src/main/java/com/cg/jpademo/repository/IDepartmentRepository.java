package com.cg.jpademo.repository;

import java.util.List;

import com.cg.jpademo.entity.DepartmentEntity;

public interface IDepartmentRepository {

	public void saveDepartment(DepartmentEntity departmentEntity);
	public DepartmentEntity getDepartmentById(int deptId);
	public List<DepartmentEntity> getAllDepartments();
}
