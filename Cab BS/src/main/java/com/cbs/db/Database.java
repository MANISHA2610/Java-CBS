package com.cbs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(true) {
			System.out.println("Connection Established");
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbsystem","root","root@pass");
		Statement st = con.createStatement();
		st.executeUpdate("INSERT INTO CAB VALUES(1267,1,'08:30:00', null)");
		//ResultSet rs = st.executeQuery("");
		System.out.println("Inserted data into Cab");
		
	}

}
