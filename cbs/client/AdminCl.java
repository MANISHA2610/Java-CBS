package com.cbs.client;

import java.util.Scanner;

import com.cbs.services.AdminImpl;
import com.cbs.client.Login;

public class AdminCl {

	public void AdminLogin() {
		Login l = new Login();
		AdminImpl ad = new AdminImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Admin login!!");
		ad.login();
		System.out.println("Choose any of the option");
		System.out.println("1. View Employees");
		System.out.println("2. View Cabs");
		System.out.println("3. Add New Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Add New Cab");
		System.out.println("6. Delete Cab");
		System.out.println("7. View all requests");
		System.out.println("8. Logout");
		
		int a = sc.nextInt();
		switch(a) {
		case 1:
			ad.viewEmp();
		case 2:
			ad.viewCabs();
		case 3:
			ad.addEmpl();
		case 4:
			ad.delEmpl();
		case 5:
			ad.addCab();
		case 6:
			ad.disableCab();
		case 7:
			ad.viewReq();
		case 8:
			ad.logout();
		}
	}
	
}
