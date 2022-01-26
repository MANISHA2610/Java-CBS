package com.cbs.client;

import com.cbs.dao.CabDaoImpl;
import com.cbs.services.AdminImpl;
import com.cbs.services.EmployeeImpl;

import java.util.Scanner;

public class EmployeeCl {
	
	EmployeeImpl em = new EmployeeImpl();
	CabDaoImpl cdi = new CabDaoImpl();
	
	
	public void EmployeeLogin() {
		EmployeeCl emcl = new EmployeeCl();
		System.out.println("Welcome to Employee login!!");
		em.login();
		emcl.EmployeeStart();

		} 
	
	public void EmployeeStart() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose any of the option");
		System.out.println("1. View Cabs");
		System.out.println("2. Raise Request");
		System.out.println("3. View Status of Previous Requests");
		System.out.println("4. View Booking History");
		System.out.println("5. Logout");
	
		int e = sc.nextInt();
		switch(e) {
		case 1:
			em.viewCabs();
			break;
		case 2:
			em.raiseReq();
			break;
		case 3:
			em.checkPrevStatus();
			break;
		case 4:
			em.checkBookHis();
			break;
		case 5:
			em.logout();
			break;
		}	
	}
}
