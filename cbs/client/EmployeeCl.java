package com.cbs.client;

import com.cbs.model.Employee;
import com.cbs.services.CabService;
import com.cbs.services.AdminImpl;
import com.cbs.dao.CabDaoImpl;
import com.cbs.services.EmployeeImpl;

import java.util.Scanner;

public class EmployeeCl {
	
	EmployeeImpl em = new EmployeeImpl();
	CabDaoImpl cdi = new CabDaoImpl();
	
	public void EmployeeLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Employee login!!");
		AdminImpl ad = new AdminImpl();
		ad.login();
		System.out.println("Choose any of the option");
		System.out.println("1. View Cabs");
		System.out.println("2. Raise Request");
		System.out.println("3. View Booking History");
		System.out.println("4. Logout");
		
		int e = sc.nextInt();
		switch(e) {
		case 1:
			ad.viewCabs();
			break;
		case 2:
			em.raiseReq();
			break;
		case 3:
			em.checkBookHis();
			break;
		case 4:
			ad.logout();
			break;
		}
	}
}
