package com.tranvandat.baithi.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tranvandat.baithi.SinhVien;

public class SinhVienDAO {
	public ArrayList<SinhVien> getSinhVienToDatabase() {
		ArrayList<SinhVien> listSinhVien = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cnn = utilsDAO.getDatabaseSQLife()) {
			Statement stmt = cnn.createStatement();
			
			String query = "SELECT MaSinhVien, HoDem, Ten, MaNganh, GioiTinh, NgaySinh, DiemTrungBinh FROM SinhVien";
			
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				var maSinhVien = rs.getString("MaSinhVien");
				var hoDem = rs.getString("HoDem");
				var ten = rs.getString("Ten");
				var gioiTinh = rs.getBoolean("GioiTinh");
				var ngaySinh = rs.getString("NgaySinh");
				var maNganh = rs.getInt("MaNganh");
				double diemTrungBinh = rs.getDouble("DiemTrungBinh");
				var newSV = new SinhVien(maSinhVien, hoDem, ten, gioiTinh, ngaySinh, maNganh, diemTrungBinh);
				listSinhVien.add(newSV);
			}
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listSinhVien;
	}
}
