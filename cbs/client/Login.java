package com.cbs.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.cbs.model.Employee;
import com.cbs.dao.CabDaoImpl;
import com.cbs.services.AdminImpl;

public class Login {
	
	public void strt() {
		System.out.println("Welcome again");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Employee login = new Employee();
		AdminCl admin = new AdminCl();
		ManagerCl manager = new ManagerCl();
		EmployeeCl employee = new EmployeeCl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to XYZ Cab Login!!");
		System.out.println("What do you want to login as?");
		System.out.println("Press 1 to login as admin");
		System.out.println("Press 2 to login as manager");
		System.out.println("Press 3 to login as employee");
		
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
			System.out.println("Copyrights @XYZ company, 2022.");
		}

	}
}