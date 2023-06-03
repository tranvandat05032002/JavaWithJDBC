	package com.tranvandat.baithi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tranvandat.baithi.NganhDaoTao;

public class NganhDAO {
	public ArrayList<NganhDaoTao> getNganhToDatabase() {
		ArrayList<NganhDaoTao> listNganhDaoTao = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cnn = utilsDAO.getDatabaseSQLife()) {
			Statement stmt = cnn.createStatement();
			
			String query = "SELECT MaNganh, TenNganh FROM NganhDaoTao";
			
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int maNganh = rs.getInt("MaNganh");
				String tenNganh = rs.getString("TenNganh");
				NganhDaoTao newNganh = new NganhDaoTao(maNganh, tenNganh);
				listNganhDaoTao.add(newNganh);
			}
			stmt.close();
			cnn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listNganhDaoTao;
	}
// insert
	public boolean insertNewNganh(int maNganh, String tenNganh) throws SQLException {
		Connection cnn = utilsDAO.getDatabaseSQLife();
		
		String query = "INSERT INTO NganhDaoTao (MaNganh, TenNganh) VALUES(?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setInt(index++, maNganh);
		stmt.setString(index++, tenNganh);
		
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
//update
	public boolean updateNganhDaoTao(int maNganh, String tenNganh) throws SQLException {
		Connection cnn = utilsDAO.getDatabaseSQLife();

		String sql = "UPDATE NganhDaoTao SET TenNganh = ? WHERE (MaNganh = ?)";
		PreparedStatement stmt = cnn.prepareStatement(sql);
		int idx = 0;
		stmt.setString(++idx, tenNganh);
		stmt.setInt(++idx, maNganh);

		int n = stmt.executeUpdate();

		stmt.close();
		cnn.close();

		return n == 1;
	}
//delete
	public boolean deleteNganhDaoTao(int maNganh) throws SQLException {
		Connection cnn = utilsDAO.getDatabaseSQLife();

		String sql = "DELETE FROM NganhDaoTao WHERE (MaNganh = ?)";
		PreparedStatement stmt = cnn.prepareStatement(sql);
		int idx = 0;
		stmt.setInt(++idx, maNganh);

		int n = stmt.executeUpdate();

		stmt.close();
		cnn.close();

		return n == 1;
	}
}
