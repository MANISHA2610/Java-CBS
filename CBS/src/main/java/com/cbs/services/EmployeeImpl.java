package com.cbs.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.cbs.dao.CabDaoImpl;

public class EmployeeImpl implements EmployeeInt{
	CabDaoImpl cdi = new CabDaoImpl();
	
	public void raiseReq() {
		try (Scanner sc = new Scanner(System.in)){
			cdi.getCon();
			String query = "insert into requests(EId, status) values(?,?);";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			System.out.println("Enter your Employee Id: ");
			int i = sc.nextInt();
			pst.setInt(1, i);
			pst.setString(2, "Pending");
			System.out.println("Your request has been raised.");
			System.out.println("Check in a while to see your request status.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ResultSet checkBookHis() {
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
			System.out.println("Your Booking History");
			System.out.println(list);
			
			return rs;
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
