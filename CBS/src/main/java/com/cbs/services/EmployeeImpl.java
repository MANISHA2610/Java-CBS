package com.cbs.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cbs.client.AdminCl;
import com.cbs.client.EmployeeCl;
import com.cbs.client.Login;
import com.cbs.dao.CabDaoImpl;
import com.cbs.model.Employee;

public class EmployeeImpl implements EmployeeInt{
	CabDaoImpl cdi = new CabDaoImpl();
	Employee log = new Employee();
	
	public void login() {
		EmployeeCl emcl = new EmployeeCl();
		Scanner sc = new Scanner(System.in);
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
					break;
				}	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		emcl.EmployeeStart();
	}
	
	public void raiseReq() {
		
		try (Scanner sc = new Scanner(System.in)){
			cdi.getCon();
			String query = "insert into requests(EId, status) values(?,?);";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			System.out.println("Enter your Employee Id: ");
			int i = sc.nextInt();
			pst.setInt(1, i);
			pst.setString(2, "Pending");
			pst.execute();
			System.out.println("Your request has been raised.");
			System.out.println("Check in a while to see your request status.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		//EmployeeCl emcl = new EmployeeCl();
		//emcl.EmployeeStart();
	}
	
	@SuppressWarnings("rawtypes")
	public ResultSet checkPrevStatus() {
		EmployeeCl emcl = new EmployeeCl();
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		try (Scanner sc = new Scanner(System.in)){
			cdi.getCon();
			java.sql.Statement st = cdi.getCon().createStatement();
			System.out.println("Enter your Employee Id: ");
			int i = sc.nextInt();
			String query = "select * from requests where EId="+ i +";";
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			while(rs.next()) {
				list.add(rs.getInt("reqId"));
				list.add(rs.getInt("EId"));
				list.add(rs.getString("status"));
			}
			System.out.println(list);
			return rs;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		emcl.EmployeeStart();
		return null;	
	}
	
	public void viewCabs() {
		EmployeeCl emcl = new EmployeeCl();
		@SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList<Comparable>();
		try {
			cdi.getCon();
			String query = "select * from cab;";
			java.sql.Statement st = cdi.getCon().createStatement();
		//	PreparedStatement pst = cdi.getCon().prepareStatement(query);
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			while(rs.next())
		      {
		        list.add(rs.getInt("cabId"));
		        list.add(rs.getInt("cabNo"));
		        list.add(rs.getInt("stat"));
		        list.add(rs.getTime("Stime").toString());
		        list.add(rs.getTime("Etime").toString());
		      }
			System.out.println("Here are the following cab details");
			System.out.println(list);
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		emcl.EmployeeStart();
	}
	
	public void checkBookHis() {
		EmployeeCl emcl = new EmployeeCl();
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		try (Scanner sc = new Scanner(System.in)){
			cdi.getCon();
			System.out.println("Enter your request Id ");
			int i = sc.nextInt();
			String query = "select * from BookingHistory where reqId="+ i +";";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("bookingId"));
				list.add(rs.getInt("cabNo"));
				list.add(rs.getTime("Stime"));
				list.add(rs.getTime("Etime"));
				list.add(rs.getInt("EId"));
				list.add(rs.getInt("reqId"));
			}
			System.out.println("Your Booking History");
			System.out.println(list);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		emcl.EmployeeStart();
	}
	
	public void logout() {
		System.out.println("Logged Out Successfully");
		Login l = new Login();
		l.strt();
	}
}
