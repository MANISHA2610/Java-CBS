package com.cbs.client;

import com.cbs.services.EmployeeImpl;

import java.util.Scanner;

public class EmployeeCl {
	
	Scanner sc=new Scanner(System.in);
	
	public void EmployeeLogin() {
		
		EmployeeImpl em = new EmployeeImpl();
		EmployeeCl emcl = new EmployeeCl();
		System.out.println("Welcome to Employee login!!");
		em.login();
		emcl.EmployeeStart();
	}	
	public void EmployeeStart() {
		EmployeeImpl em = new EmployeeImpl();
		System.out.println("Choose any of the option");
		System.out.println("1. View Cabs");
		System.out.println("2. Raise Request");
		System.out.println("3. View Status of Previous Requests");
		System.out.println("4. View Booking History");
		System.out.println("5. Logout");
		int e = 0;
		e = sc.nextInt();
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