package com.cbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CabDaoImpl implements CabDao {
	
	public Connection getCon(){
		Connection con = null;	
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbsystem","root","root@pass");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
	
}