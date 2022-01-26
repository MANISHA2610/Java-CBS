package com.cbs.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cbs.client.Login;
import com.cbs.model.Employee;
import com.cbs.model.CabModel;
import com.cbs.dao.CabDaoImpl;
//import com.cbs.services.EmployeeImpl;

public class AdminImpl implements CabService{
	Login l = new Login();
	CabDaoImpl cdi = new CabDaoImpl();
	Scanner sc = new Scanner(System.in);
	Employee log = new Employee();
	CabModel cm = new CabModel();
	EmployeeImpl emImp = new EmployeeImpl();
	
	
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
	}
	
	public void delCab() {
		try {
			cdi.getCon();
			String query = "delete from cab where cabId= ?";
			//	java.sql.Statement st = cdi.getCon().createStatement();
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
	}
	@SuppressWarnings("unchecked")
	public void viewCabs() {
		
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
		finally {
			sc.close();
	}
	}	
		
	public void addEmpl() {
		
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
			
			System.out.println("Enter your password: ");
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
	}
	public void delEmpl() {
		
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
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void viewEmp() {
		
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
			System.out.println(list);
			
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			sc.close();
	}
		
	}
	public void logout() {
		System.out.println("Logged out successfully!!");
		l.strt();
	}
	
	public void viewReq() {
		try {
			emImp.checkBookHis();
			if(emImp.checkBookHis().getString("password").contentEquals("Approved")) {
				sendCabDet();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void sendCabDet() {
		ManagerImpl manImp = new ManagerImpl();
		if(manImp.z == 1) {
			ArrayList list = new ArrayList<Comparable>();
			try {
				cdi.getCon();
				String query = "select * from cab where status ='1';";
				java.sql.Statement st = cdi.getCon().createStatement();
			//	PreparedStatement pst = cdi.getCon().prepareStatement(query);
				ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
				while(rs.next())
			      {
			        list.add(rs.getInt("cabId"));
			        list.add(rs.getInt("cabNo"));
			        list.add(rs.getTime("Stime").toString());
			        list.add(rs.getTime("Etime").toString());
			      }
				System.out.println("Here are the following cab details");
				System.out.println(list);
			}
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}
