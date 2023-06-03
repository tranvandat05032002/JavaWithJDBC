package com.tvdat.ontap.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tvdat.ontap.MODELS.SinhVien;

public class SinhVienDAO {
	public ArrayList<SinhVien> getSinhVienDB(){
		ArrayList<SinhVien> lstSV = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cnn = utilsDAO.getDBSQLife()){
			java.sql.Statement stm = cnn.createStatement();
			
			String query = "SELECT maSinhVien, hoDem, ten, maNganh, gioiTinh, ngaySinh, diemTrungBinh FROM SinhVien";
			
			rs = stm.executeQuery(query);
			while(rs.next()) {
				var maSinhVien = rs.getString("maSinhVien");
				var hoDem = rs.getString("hoDem");
				var ten = rs.getString("ten");
				var maNganh = rs.getString("maNganh");
				var gioiTinh = rs.getInt("gioiTinh");
				var nagySinh = rs.getString("ngaySinh");
				var diemTrungBinh = rs.getFloat("diemTrungBinh");
				
				boolean gioiTinhRS = (gioiTinh == 1) ? true : false;
				
				SinhVien sv = new SinhVien(maSinhVien, hoDem, ten, gioiTinhRS, nagySinh, maNganh, diemTrungBinh);
				lstSV.add(sv);
			}
			stm.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		return lstSV;
	}
}
