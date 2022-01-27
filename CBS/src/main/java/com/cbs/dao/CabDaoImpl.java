package com.cbs.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CabDaoImpl implements CabDao {
	
	public Connection getCon(){
	
	try {
		FileInputStream fs = new FileInputStream("/CBS/src/main/java/com/cbs/dao/db.properties");
		Properties properties = new Properties(); 
		properties.load(fs);
		Connection con = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return getCon();
	}
	
}