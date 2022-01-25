package com.cbs.client;

import java.util.Scanner;

import com.cbs.services.AdminImpl;

public class ManagerCl {

	public void ManagerLogin() {
		Login l = new Login();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Manager login!!");
		AdminImpl ad = new AdminImpl();
		ad.login();
		System.out.println("Choose any of the option");
		System.out.println("1. View Employees");
		System.out.println("2. Approve Requests");
		System.out.println("3. Logout");
		
		int m = sc.nextInt();
		switch(m) {
		case 1:
			ad.viewEmp();
			break;
		case 2:
			break;
		case 3:
			ad.logout();
		}
	}
}
