package com.tranvandat.baithi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utilsDAO {
	static Connection getDatabaseSQLife() throws SQLException {
		String url = "";
		try {
			url = "jdbc:sqlite:/Users/spiderman/Desktop/Code/Java/SQLife/SinhVienDB.db";
			return DriverManager.getConnection(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url);
	}
}
