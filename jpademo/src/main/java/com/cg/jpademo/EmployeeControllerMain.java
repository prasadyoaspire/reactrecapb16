package com.cg.jpademo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.jpademo.controller.EmployeeController;
import com.cg.jpademo.entity.EmployeeEntity;

public class EmployeeControllerMain {

	public static void main(String[] args) {
		
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		
		EmployeeController employeeController = context.getBean(EmployeeController.class);
		
		int deptId = 10;
		
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setEmpId(1111);
		empEntity.setEmpName("Karan");
		empEntity.setSalary(55000);
		empEntity.setEmail("karn@tmail.com");
		empEntity.setMobile("9638527410");
		
		employeeController.save(empEntity, deptId);
		
		context.close();


	}

}
