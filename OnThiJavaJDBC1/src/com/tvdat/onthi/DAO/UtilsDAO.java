package com.tvdat.onthi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilsDAO {
	static Connection getDatabaseSQLife() throws SQLException {
		String url = "";
		try {
			url = "jdbc:sqlite:/Users/spiderman/Desktop/Code/Java/SQLife/21t1020285.db";
//			System.out.println("successfully!!");
			return DriverManager.getConnection(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url);
	}
}
