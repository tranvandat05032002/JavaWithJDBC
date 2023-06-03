package com.tvdat.ontap.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utilsDAO {
	static Connection getDBSQLife() throws SQLException {
		String url = "";
		try {
			url = "jdbc:sqlite:/Users/spiderman/Desktop/Code/Java/SQLife/SinhVienDatabase.db";
			System.out.println("Connect successfully");
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url);
	}
}
