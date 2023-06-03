package com.tvdat.quanlytb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tvdat.quanlytb.MODELS.ThietBi;

public class ThietBiDAO {
	public ArrayList<ThietBi> getTableTBDatabase(){
		ArrayList<ThietBi> listTB = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cnn = UtilsDAO.getDatabaseSQLife()) {
			Statement stmt = cnn.createStatement();
			String query = "SELECT *\n"
					+ "FROM ThietBi";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String maNhom = rs.getString("maNhom");
				String maTB = rs.getString("maTB");
				String tenTB = rs.getString("tenTB");
				String ngaySanXuat = rs.getString("ngaySanXuat");
				int gia = rs.getInt("gia");
				
				ThietBi tb = new ThietBi(maNhom, maTB, tenTB, ngaySanXuat ,gia);
				listTB.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTB;
	}
	public boolean insertTB(String maNhom, String maTB, String tenTB, String ngaySanXuat, int gia) throws SQLException{
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String query = "INSERT INTO ThietBi(maNhom, maTB, tenTB, ngaySanXuat, gia) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maNhom);
		stmt.setString(index++, maTB);
		stmt.setString(index++, tenTB);
		stmt.setString(index++, ngaySanXuat);
		stmt.setInt(index++, gia);
		int n = stmt.executeUpdate();
		stmt.close();
		cnn.close();
		return n == 1;
	}
}
