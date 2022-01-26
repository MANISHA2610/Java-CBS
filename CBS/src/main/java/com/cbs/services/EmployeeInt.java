package com.cbs.services;

import java.sql.ResultSet;

public interface EmployeeInt {
	
	public void login();
	public void raiseReq();
	public ResultSet checkPrevStatus();
	public void viewCabs();
	public void checkBookHis();
	public void logout();
}
