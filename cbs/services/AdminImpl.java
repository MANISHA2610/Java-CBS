package com.cbs.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cbs.client.Login;
import com.cbs.model.Employee;
import com.cbs.dao.CabDaoImpl;

public class AdminImpl implements CabService{
	Login l = new Login();
	CabDaoImpl cdi = new CabDaoImpl();
	AdminImpl login = new AdminImpl();
	Scanner sc = new Scanner(System.in);
	Employee log = new Employee();
	
	public void login() {
		cdi.getCon();
		System.out.println("Enter your name");
		log.setName(sc.nextLine());
		System.out.println("Enter your password");
		log.setPassword(sc.nextLine());
		System.out.println("Enter your EId");
		log.setEmpId(sc.nextInt());
		try {
			String query = "select name,pass from employee where EId=?;";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			pst.setInt(1, log.getEmpId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).contentEquals(log.getName()) && rs.getString(2).contentEquals(log.getPassword())){
					System.out.println("Logged in Successfully as "+ log.getName()+"!!");
				}
				else{
					System.out.println("You have entered wrong credentials.");
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCab(){
		System.out.println("******Welcome to XYZ Company Cab Services******");
		System.out.println("Enter your name");
		log.setName(sc.nextLine());
		pst.setString(2, log.getName());
		System.out.println("Enter your password");
		log.setPassword(sc.nextLine());
		pst.setString(4, log.getPassword());
		System.out.println("Enter your Employee Id:");
		log.setEmpId(sc.nextInt());
		pst.setInt(1, log.getEmpId());
		System.out.println("Enter your department");
		sc.nextLine();
		log.setDept(sc.nextLine());
		pst.setString(5, log.getDept());
		log.toString();
*/
	}
	
	public void disableCab() {
		
	}
	public void viewCabs() {
		
	}
	public void addEmpl() {
		
	}
	public void delEmpl() {
		
	}
	public void viewEmp() {
		
	}
	public void logout() {
		System.out.println("Logged out successfully!!");
		l.strt();
	}
	public void sendCabDet() {
		
	}
	
	public void viewReq() {
		
	}
	
}
