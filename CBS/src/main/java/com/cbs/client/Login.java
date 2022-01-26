package com.cbs.client;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	
	public void strt() {
		System.out.println("Welcome to XYZ Cab Services Login!!");
		System.out.println("What do you want to login as?");
		System.out.println("Press 1 to login as admin");
		System.out.println("Press 2 to login as manager");
		System.out.println("Press 3 to login as employee");	
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Login l = new Login();
		AdminCl admin = new AdminCl();
		ManagerCl manager = new ManagerCl();
		EmployeeCl employee = new EmployeeCl();
		Scanner sc = new Scanner(System.in);
		
		l.strt();
		int i = sc.nextInt();
		switch(i) {
		case 1:
			admin.AdminLogin();
			break;
		case 2:
			manager.ManagerLogin();
			break;
		case 3:
			employee.EmployeeLogin();
			break;
		default:
			l.strt();
		}
		sc.close();

	}
}