package com.tvdat.ontap.UI;

import java.util.ArrayList;

import com.tvdat.ontap.DAO.SinhVienDAO;
import com.tvdat.ontap.MODELS.SinhVien;

public class ChuongTrinh {
	static void getSVCNTT() {
		SinhVienDAO svDAO = new SinhVienDAO();
		ArrayList<SinhVien> lstSVDAO = svDAO.getSinhVienDB();
		System.out.println("STT" + "\t" + "MaSinhVien" + "\t" + "Ho va Ten" + "\t\t" + "GioiTinh" + "\t" + "NgaySinh");
		for (int i = 0; i < lstSVDAO.size(); i++) {
			SinhVien x = lstSVDAO.get(i);
			if (x.getMaNganh().equals("102")) {
				System.out.println((i + 1) + "\t" + x.getThongTinCNTT());
			}
		}
	}
	public static void main(String[] args) {
		getSVCNTT();

	}

}
