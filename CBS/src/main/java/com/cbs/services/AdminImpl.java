package com.cbs.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cbs.client.AdminCl;
import com.cbs.client.Login;
import com.cbs.model.Employee;
import com.cbs.model.CabModel;
import com.cbs.dao.CabDaoImpl;

public class AdminImpl implements CabService{
	Login l = new Login();
	CabDaoImpl cdi = new CabDaoImpl();
	Scanner sc = new Scanner(System.in);
	Employee log = new Employee();
	CabModel cm = new CabModel();
	EmployeeImpl emImp = new EmployeeImpl();
	
	public void login() {
		AdminImpl ad = new AdminImpl();
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
					ad.login();
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCab(){
		try {
			cdi.getCon();
			String query = "insert into cab(cabId, cabNo, stat, Stime, Etime)"+ " values(?,?,?,?,?)";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			System.out.println("******Welcome to XYZ Company Cab Services******");
			System.out.println("      ");
			System.out.println("Add a New Cab");
			System.out.println("      ");
			System.out.println("Kindly Enter the following details");
			
			System.out.println("Enter Cab Id: ");
			cm.setCabId(sc.nextInt());
			pst.setInt(1, cm.getCabId());
			
			System.out.println("Enter Cab Number: ");
			cm.setCabNo(sc.nextInt());
			pst.setInt(2, cm.getCabNo());
			
			System.out.println("Enter Cab Availaibility: ");
			cm.setStatus(sc.nextBoolean());
			pst.setBoolean(3, cm.getStatus());
			sc.nextLine();
			System.out.println("Enter Cab Start Time: ");
			cm.setStartTime(sc.nextLine());
			pst.setString(4, cm.getStartTime());
			
			System.out.println("Enter Cab End Time: ");
			cm.setEndTime(sc.nextLine());
			pst.setString(5, cm.getEndTime());
			
			int i = pst.executeUpdate();
		      if(i!=0){
		        System.out.println("New Cab added Successfully!!");
		        log.toString();
		      }
		      else{
		        System.out.println("Sorry, Failed to add new cab!");
		      }
		      
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		AdminCl adcl = new AdminCl();
		adcl.AdminStart();
	}
	
	public void delCab() {
		AdminCl adcl = new AdminCl();
		try {
			cdi.getCon();
			String query = "delete from cab where cabId= ?";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			System.out.println("Enter the Cab Id to delete: ");
			int i =sc.nextInt();
			pst.setInt(1, i);
			pst.execute();
			if(true){
				System.out.println("Cab Record deleted successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		adcl.AdminStart();
	}
	
	@SuppressWarnings("unchecked")
	
	public void viewCabs() {
		AdminCl adcl = new AdminCl();
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
		adcl.AdminStart();
	}	
		
	public void addEmpl() {
		AdminCl adcl = new AdminCl();
		try {
			cdi.getCon();
			String query = "insert into employee(Eid, name, email, pass, manager, department)"+ " values(?,?,?,?,?,?)";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			
			System.out.println("******Welcome to XYZ Company Cab Services******");
			System.out.println("      ");
			System.out.println("Add a New Employee");
			System.out.println("      ");
			System.out.println("Kindly Enter the following details");
			System.out.println("Enter Employee Id: ");
			
			log.setEmpId(sc.nextInt());
			sc.nextLine();
			pst.setInt(1, log.getEmpId());
			
			System.out.println("Enter Employee name: ");
			log.setName(sc.nextLine());
			pst.setString(2, log.getName());
			
			System.out.println("Enter Employee email Id: ");
			log.setEmail(sc.nextLine());
			pst.setString(3, log.getEmail());
			
			System.out.println("Create new password: ");
			log.setPassword(sc.nextLine());
			pst.setString(4, log.getPassword());
			
			System.out.println("Is the employee manager? Y/N");
			String m = sc.nextLine();
			if(m.equalsIgnoreCase("y")) {
				pst.setBoolean(5, true);
			}
			else {
				pst.setBoolean(5, false);
			}
			
			System.out.println("Enter Employee department");
			log.setDept(sc.nextLine());
			pst.setString(6, log.getDept());
			
			int i = pst.executeUpdate();
		      if(i!=0){
		        System.out.println("New Employee added Successfully!!");
		        log.toString();
		      }
		      else{
		        System.out.println("Sorry, Failed to add new employee!");
		      }
		      
		      
		      
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		adcl.AdminStart();
	}
	
	public void delEmpl() {
		AdminCl adcl = new AdminCl();
		try {
			cdi.getCon();
			String query = "delete from employee where EId= ?";
			//	java.sql.Statement st = cdi.getCon().createStatement();
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			System.out.println("Enter the Employee Id to delete: ");
			int i =sc.nextInt();
			pst.setInt(1, i);
			pst.execute();
			if(true){
				System.out.println("Employee Record deleted successfully");
				}
			//else{
			//	System.out.println("Sorry, Failed to delete employee record!");
			//	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		adcl.AdminStart();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void viewEmp() {
		AdminCl adcl = new AdminCl();
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
		adcl.AdminStart();
	}
	
	public void logout() {
		System.out.println("Logged out successfully!!");
		l.strt();
	}
	
	public void viewReq() {
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		try{
			cdi.getCon();
			java.sql.Statement st = cdi.getCon().createStatement();
			String query = "select * from requests;";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(rs.getInt("reqId"));
				list.add(rs.getInt("EId"));
				list.add(rs.getString("status"));
			}
			System.out.println(list);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		AdminCl adcl = new AdminCl();
		adcl.AdminStart();
	}

	public void sendCabDet() {	
		try {
			cdi.getCon();
			String query = "insert into BookingHistory (cabNo, Stime, Etime) select cabNo, Stime, Etime from cab where stat=0;";
			PreparedStatement pst = cdi.getCon().prepareStatement(query);
			pst.execute();	
			String query1 = "update BookingHistory set  reqId = ? , EId = ? where cabNo=?;";
			PreparedStatement pst1 = cdi.getCon().prepareStatement(query1);
			
			System.out.println("Enter approved request Id: ");
			int reqId = sc.nextInt();
			pst1.setInt(1, reqId);
			
			System.out.println("Enter employee Id: ");
			int EId = sc.nextInt();
			pst1.setInt(2, EId);
			
			System.out.println("Enter cab no: ");
			int cabNo = sc.nextInt();
			pst1.setInt(3, cabNo);
			
			pst1.execute();
			System.out.println("Details sent to the user");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		AdminCl adcl = new AdminCl();
		adcl.AdminStart();
	}
}
