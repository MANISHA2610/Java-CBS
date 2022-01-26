package com.cbs.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cbs.dao.CabDaoImpl;

public class ManagerImpl implements ManagerInt{
	
	CabDaoImpl cdi = new CabDaoImpl();
	public int z = 0;
	

	public int acceptReq() {
		
		try(Scanner sc = new Scanner(System.in)) {
			cdi.getCon();
			System.out.println("Enter the cab request Id to be Approved: ");
			int rId = sc.nextInt();
			String query = "update requests set status = 'Approved' where reqId =?;";
		//	java.sql.Statement st = cdi.getCon().createStatement();
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			pst.setInt(1, rId);
			pst.execute();
			if(true) {
				System.out.println(rId+" Request approved!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return z = 1;
	}
	
	public int rejectReq() {
		try(Scanner sc = new Scanner(System.in)) {
			cdi.getCon();
			System.out.println("Enter the cab request Id to be Rejected: ");
			int rId = sc.nextInt();
			String query = "update requests set status = 'Rejected' where reqId =?;";
		//	java.sql.Statement st = cdi.getCon().createStatement();
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			pst.setInt(1, rId);
			pst.execute();
			if(true) {
				System.out.println(rId+" Request rejected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return z = 2;
	}
	
	public void viewAllReq() {
		ArrayList list = new ArrayList();
		try {
			cdi.getCon();
			String query = "select * from requests;";
			java.sql.Statement st = cdi.getCon().createStatement();
		//	PreparedStatement pst = cdi.getCon().prepareStatement(query);
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			while(rs.next())
		      {
		        list.add(rs.getInt("reqId"));
		        list.add(rs.getInt("cabId"));
		        list.add(rs.getString("status"));
		      }
			System.out.println("Here are the following cab details");
			System.out.println(list);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ManagerImpl manImp = new ManagerImpl();	
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Press 'a' to approve requests.");
			System.out.println("Press 'r' to approve requests.");
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
		
	}
}
