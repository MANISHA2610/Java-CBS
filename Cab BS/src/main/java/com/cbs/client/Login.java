package com.cbs.client;

import java.util.Scanner;

public class Login {
	
	Scanner sc = new Scanner(System.in);
	
	public void strt() {
		System.out.println("Welcome to XYZ Cab Services Login!!");
		System.out.println("What do you want to login as?");
		System.out.println("Press 1 to login as admin");
		System.out.println("Press 2 to login as manager");
		System.out.println("Press 3 to login as employee");	
		System.out.println("Press 4 to exit");
		Login l = new Login();
		l.FirstLogic();
	}
	
	public void FirstLogic(){
		
		AdminCl admin = new AdminCl();
		ManagerCl manager = new ManagerCl();
		EmployeeCl employee = new EmployeeCl();
		int i = sc.nextInt();
		switch(i) {
		case 1:
			admin.AdminLogin();
			break;
		case 2:
			manager.ManagerStart();
			break;
		case 3:
			employee.EmployeeLogin();
			break;
		case 4:
			break;
		}
	}
	public static void main(String[] args){
		
		Login l = new Login();
		l.strt();
		l.FirstLogic();
	}
}