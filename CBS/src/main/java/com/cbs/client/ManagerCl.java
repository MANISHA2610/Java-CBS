package com.cbs.client;

import java.util.Scanner;

import com.cbs.services.AdminImpl;
import com.cbs.services.ManagerImpl;

public class ManagerCl {
	
	Scanner sc = new Scanner(System.in);
	
	public void ManagerLogin() {
		ManagerImpl manImp = new ManagerImpl();
		System.out.println("Welcome to Manager login!!");
		manImp.login();
		System.out.println("Choose any of the option");
		System.out.println("1. View Employees");
		System.out.println("2. View Cab Requests");
		System.out.println("3. Logout");
		
		int m = sc.nextInt();
		switch(m) {
		case 1:
			manImp.viewEmp();
			break;
		case 2:
			manImp.viewAllReq();
			break;
		case 3:
			manImp.logout();
			break;
		}
		
	}
}
