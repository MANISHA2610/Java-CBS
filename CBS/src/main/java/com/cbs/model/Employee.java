package com.cbs.model;

public class Employee{
	
	String name, dept, email, password;
	Integer empId;
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", email=" + email + ", empId=" + empId + ", contact="
				+", mKey=" + ", aKey=" + "]";
	}
	
	
}
