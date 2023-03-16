package com.cg.jpademo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department_tbl")
public class DepartmentEntity {

	@Id
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;	
	
	@OneToMany(mappedBy = "department")
	private Set<EmployeeEntity> employees = new HashSet<>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}	
}
