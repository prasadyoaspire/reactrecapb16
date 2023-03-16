package com.cg.jpademo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.jpademo.controller.DepartmentController;
import com.cg.jpademo.entity.DepartmentEntity;

public class DepartmentControllerMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		
		DepartmentController departmentController = context.getBean(DepartmentController.class);
		
		DepartmentEntity deptEntity = new DepartmentEntity();
		deptEntity.setDeptId(20);
		deptEntity.setDeptName("HR");
		
		departmentController.save(deptEntity);

	}

}
