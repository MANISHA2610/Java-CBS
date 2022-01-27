package com.cbs.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cbs.client.Login;
import com.cbs.client.ManagerCl;
import com.cbs.dao.CabDaoImpl;
import com.cbs.model.Employee;

public class ManagerImpl implements ManagerInt{
	
	CabDaoImpl cdi = new CabDaoImpl();
	Employee log = new Employee();
	Scanner sc = new Scanner(System.in);
	public int z = 0;
	
	public void login() {
		ManagerImpl manImp = new ManagerImpl();	
		cdi.getCon();
		System.out.println("Enter your name");
		log.setName(sc.nextLine());
		System.out.println("Enter your password");
		log.setPassword(sc.nextLine());
		try {
			String query = "select name,pass from employee where name=?;";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			pst.setString(1, log.getName());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).contentEquals(log.getName()) && rs.getString(2).contentEquals(log.getPassword())){
					System.out.println("Logged in Successfully as "+ log.getName()+"!!");
				}
				else{
					System.out.println("You have entered wrong credentials.");
					manImp.login();	
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ManagerCl manCl = new ManagerCl();
		manCl.ManagerLogin();
	}
	
	@SuppressWarnings("unchecked")
	public void viewEmp() {
		@SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList();
		try {
			cdi.getCon();
			String query = "select * from employee where EId > 100;";
			java.sql.Statement st = cdi.getCon().createStatement();
		//	PreparedStatement pst = cdi.getCon().prepareStatement(query);
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			while(rs.next())
		      {
		        list.add(rs.getInt("EId"));
		        list.add(rs.getString("name"));
		        list.add(rs.getString("email"));
		        list.add(rs.getString("department"));
		      }
			System.out.println("Here are the following cab details");
			for(int i=0; i<list.size();i++) {
				if(list.get(i).equals("")){
					System.out.println("\n");	
			}
				System.out.println(list.get(i));
	}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		ManagerCl manCl = new ManagerCl();
		manCl.ManagerLogin();
	}

	public void acceptReq() {
		try{
			cdi.getCon();
			System.out.println("Enter the cab request Id to be Approved: ");
			int rId = sc.nextInt();
			String query1 = "select EId from requests where reqId = ?;";
			String query = "update requests set status = 'Approved' where reqId =?;";
		//	java.sql.Statement st = cdi.getCon().createStatement();
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			PreparedStatement pst1 = cdi.getCon().prepareStatement(query1);
			pst.setInt(1, rId);
			pst1.setInt(1, rId);
			pst.execute();
			ResultSet rs = pst1.executeQuery();
			@SuppressWarnings("unused")
			int EId = 0;
			while(rs.next()) {
				EId = rs.getInt("EId");
			}
			if(true) {
				System.out.println(rId+" Request approved!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ManagerCl manCl = new ManagerCl();
		manCl.ManagerLogin();
	}
	
	public void rejectReq() {
		try{
			cdi.getCon();
			System.out.println("Enter the cab request Id to be Rejected: ");
			int rId = sc.nextInt();
			String query = "update requests set status = 'Rejected' where reqId =?;";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			pst.setInt(1, rId);
			pst.execute();
			if(true) {
				System.out.println(rId+" Request rejected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ManagerCl manCl = new ManagerCl();
		manCl.ManagerLogin();
	}
	
	public void viewAllReq() {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList<Comparable> list = new ArrayList();
		try {
			cdi.getCon();
			String query = "select * from requests;";
			java.sql.Statement st = cdi.getCon().createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			while(rs.next())
		      {
		        list.add(rs.getInt("reqId"));
		        list.add(rs.getInt("EId"));
		        list.add(rs.getString("status"));
		      }
			System.out.println("Here are the following cab details");
			for(int i=0; i<list.size();i++) {
				if(list.get(i).equals("")){
					System.out.println("\n");	
			}
				System.out.println(list.get(i));
	}
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ManagerImpl manImp = new ManagerImpl();	
		try{
			System.out.println("Press 'a' to approve requests.");
			System.out.println("Press 'r' to reject requests.");
			String a = sc.nextLine();
			if(a.equalsIgnoreCase("a")) {
				manImp.acceptReq();
			}
			else if(a.equalsIgnoreCase("r")){
				manImp.rejectReq();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ManagerCl manCl = new ManagerCl();
		manCl.ManagerLogin();
	}
    
	public void logout() {
		Login l = new Login();
		System.out.println("Logged out successfully!!");
		l.strt();
	}
	

}
