package com.tvdat.quanlytb.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tvdat.quanlytb.MODELS.NhomTB;

public class NhomTBDAO {
	public ArrayList<NhomTB> getNhomTBDatabase(){
		ArrayList<NhomTB> listNhomTB = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cnn = UtilsDAO.getDatabaseSQLife()){
			Statement stmt = cnn.createStatement();
			String query = "SELECT* FROM NhomTB";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String maNhom = rs.getString("maNhom");
				String tenNhom = rs.getString("tenNhom");
				
				NhomTB ntb = new NhomTB(maNhom, tenNhom);
				listNhomTB.add(ntb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNhomTB;
	}
}
