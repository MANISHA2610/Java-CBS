package com.cbs.model;

public class Employee{
	
	String name, dept, email, driverName, password;
	Integer empId, contact, mKey, aKey, cabNo, driverContact;
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Integer getCabNo() {
		return cabNo;
	}
	public void setCabNo(Integer cabNo) {
		this.cabNo = cabNo;
	}
	public Integer getDriverContact() {
		return driverContact;
	}
	public void setDriverContact(Integer driverContact) {
		this.driverContact = driverContact;
	}

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
	public Integer getContact() {
		return contact;
	}
	public void setContact(Integer contact) {
		this.contact = contact;
	}
	public Integer getmKey() {
		return mKey;
	}
	public void setmKey(Integer mKey) {
		this.mKey = mKey;
	}
	public Integer getaKey() {
		return aKey;
	}
	public void setaKey(Integer aKey) {
		this.aKey = aKey;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", email=" + email + ", empId=" + empId + ", contact="
				+ contact + ", mKey=" + mKey + ", aKey=" + aKey + "]";
	}
	
	
}
