package com.cbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.cbs.dao.CabDao;

public class CabDaoImpl implements CabDao {
	
	public Connection getCon(){
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(true) {
			System.out.println("Connection Established");
		}
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbsystem","root","root@pass");
		System.out.println("Connection Established successfully!!");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
	
}