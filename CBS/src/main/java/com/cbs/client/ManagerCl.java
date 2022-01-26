package com.cbs.client;

import java.util.Scanner;

import com.cbs.services.AdminImpl;
import com.cbs.services.ManagerImpl;

public class ManagerCl {
	
	ManagerImpl manImp = new ManagerImpl();

	public void ManagerLogin() {
		Login l = new Login();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Manager login!!");
		AdminImpl ad = new AdminImpl();
		ad.login();
		System.out.println("Choose any of the option");
		System.out.println("1. View Employees");
		System.out.println("2. View Cab Requests");
		System.out.println("3. Logout");
		
		int m = sc.nextInt();
		switch(m) {
		case 1:
			ad.viewEmp();
			break;
		case 2:
			manImp.viewAllReq();
			break;
		case 3:
			ad.logout();
			break;
		}
	}
}
