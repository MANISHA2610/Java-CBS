package com.cbs.client;

import java.util.Scanner;

import com.cbs.services.AdminImpl;

public class AdminCl {
	
	Scanner sc = new Scanner(System.in);
	
	public void AdminLogin() {
		AdminImpl ad = new AdminImpl();
		AdminCl adcl = new AdminCl();
		System.out.println("Welcome to Admin login!!");
		ad.login();
		adcl.AdminStart();
	}
	
	public void AdminStart() {
		AdminImpl ad = new AdminImpl();
		System.out.println("Choose any of the option");
		System.out.println("1. View Employees");
		System.out.println("2. View Cabs");
		System.out.println("3. Add New Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Add New Cab");
		System.out.println("6. Delete Cab");
		System.out.println("7. View all requests");
		System.out.println("8. Send cab details to Employee");
		System.out.println("9. Logout");
		int a = sc.nextInt();
		switch(a) {
		case 1:
			ad.viewEmp();
			break;
		case 2:
			ad.viewCabs();
			break;
		case 3:
			ad.addEmpl();
			break;
		case 4:
			ad.delEmpl();
			break;
		case 5:
			ad.addCab();
			break;
		case 6:
			ad.delCab();
			break;
		case 7:
			ad.viewReq();
			break;
		case 8:
			ad.sendCabDet();
			break;
		case 9:
			ad.logout();
			break;
		}
	}
		
}
	

