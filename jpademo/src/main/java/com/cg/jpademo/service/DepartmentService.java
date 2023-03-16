package com.cg.jpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.jpademo.entity.DepartmentEntity;
import com.cg.jpademo.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;
	
	@Transactional
	@Override
	public void addDepartment(DepartmentEntity departmentEntity) {		
		departmentRepository.saveDepartment(departmentEntity);		
	}

	@Override
	public DepartmentEntity findDepartmentById(int deptId) {		
		DepartmentEntity departmentEntity = departmentRepository.getDepartmentById(deptId);
		return departmentEntity;
	}

	@Override
	public List<DepartmentEntity> findAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

}
