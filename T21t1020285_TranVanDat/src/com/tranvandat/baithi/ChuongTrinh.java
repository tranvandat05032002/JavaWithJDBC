package com.tranvandat.baithi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tranvandat.baithi.DAO.NganhDAO;
import com.tranvandat.baithi.DAO.SinhVienDAO;

public class ChuongTrinh {
	static void getSVCNTTT() {
		SinhVienDAO svDAO = new SinhVienDAO();
		ArrayList<SinhVien> listSVDAO = svDAO.getSinhVienToDatabase();
		System.out.println("STT" + "\t" + "MaSinhVien" + "\t" + "Ho va Ten" + "\t\t" + "GioiTinh" + "\t" + "NgaySinh");
		for (int i = 0; i < listSVDAO.size(); i++) {
			SinhVien x = listSVDAO.get(i);
			if (x.getMaNganh() == 101) {
				System.out.println((i + 1) + "\t" + x.getThongTinCNTT());
			}
		}
	}

	static void getNganhDaoTao() {
		NganhDAO nganhDAO = new NganhDAO();
		ArrayList<NganhDaoTao> listNganh = nganhDAO.getNganhToDatabase();
		System.out.println("STT" + "\t" + "MaNganh" + "\t" + "TenNganhDaoTao");
		for (int i = 0; i < listNganh.size(); i++) {
			NganhDaoTao x = listNganh.get(i);
			System.out.println((i + 1) + "\t" + x.getThongTin());
		}
	}
	static void soSinhVienTheoNganh() {
		SinhVienDAO svDAO = new SinhVienDAO();
		ArrayList<SinhVien> listSVDAO = svDAO.getSinhVienToDatabase();
		NganhDAO nganhDAO = new NganhDAO();
		ArrayList<NganhDaoTao> listNganh = nganhDAO.getNganhToDatabase();
		System.out.println("STT" + "\t" + "Ma DT" + "\t" + "TenNganhDT" + "\t" + "So Sinh Vien");
		for(int i = 0; i < listNganh.size(); i++) {
			NganhDaoTao nganhHoc = listNganh.get(i);
			int countSV = 0;
			for(int j = 0; j < listSVDAO.size(); j++) {
				SinhVien svJ = listSVDAO.get(j);
				if(nganhHoc.getMaNganh() == svJ.getMaNganh()) {
					countSV++;
				}
			}
			System.out.println((i + 1) + "\t" + nganhHoc.getThongTin() + "\t\t" + countSV);
		}
	}
	static void getSinhVienDTBMax() {
		SinhVienDAO svDAO = new SinhVienDAO();
		ArrayList<SinhVien> listSV = svDAO.getSinhVienToDatabase();
		NganhDAO nganhDAO = new NganhDAO();
		ArrayList<NganhDaoTao> listNganh = nganhDAO.getNganhToDatabase();
		double maxDTB = 0;
		for(int i = 0; i < listSV.size(); i++) {
			SinhVien newSinhVien = listSV.get(i);
			if(newSinhVien.getDTB() > maxDTB) {
				maxDTB = newSinhVien.getDTB();
			}
		}
		System.out.println("Danh sach sinh vien co diem trung binh cao nhat:");
		System.out.println("Hoten\t\t\tMaSinhVien\tTenNganh\tDiemTrungBinh");
		int countMax = 0;
		for(int i = 0; i < listSV.size(); i++) {
			SinhVien newSinhVien = listSV.get(i);
			if(newSinhVien.getDTB() == maxDTB) {
				countMax++;
				if(countMax < 3) {
					for(int j = 0; j < listNganh.size(); j++) {
						NganhDaoTao newNganh  = listNganh.get(j);
						if(newNganh.getMaNganh() == newSinhVien.getMaNganh()) {
							System.out.println(newSinhVien.getHoDem() + " " + newSinhVien.getTen() + "\t\t" + newSinhVien.getMaSinhVien() + "\t\t" + newNganh.getTenNganh() + "\t\t" + newSinhVien.getDTB());
						}
					}	
				}
				else {
					break;
				}
			}
		}
		
	}
	
	static ArrayList<NganhDaoTao> readResultsFile(){
		ArrayList <NganhDaoTao> listNganh = new ArrayList<>();
		try {
			BufferedReader br  = new BufferedReader(new FileReader("/Users/spiderman/Desktop/Java/File/listNganh.txt"));
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				else {
					String listLine[] = line.trim().split(",");
					for(int i = 0 ; i < listLine.length; i++) {
						int maNganhFromFile = Integer.parseInt(listLine[0]);
						String tenNganhFromFIle = listLine[1];
						
						NganhDaoTao x = new NganhDaoTao(maNganhFromFile, tenNganhFromFIle);
						listNganh.add(x);
						break;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listNganh;
	}
//insert
		private static void nganhInsert() {
			NganhDAO dao = new NganhDAO();
			try {
				for(int i = 0; i < readResultsFile().size(); i++) {
				boolean insertOK = dao.insertNewNganh(readResultsFile().get(i).getMaNganh(),  readResultsFile().get(i).getTenNganh());
				if (insertOK)
					System.out.println("insert Successfully!!!");
				else
					System.out.println("Error");
			}
			} catch (SQLException e) {
				System.out.println("Lỗi trong quá trình INSERT\n" + e.getMessage());
			}
		}
//delete 
		private static void nganhDelete() {
			NganhDAO dao = new NganhDAO();
			try {
				
				boolean insertOK = dao.deleteNganhDaoTao(399);
				if (insertOK)
					System.out.println("delete Successfully!!!");
				else
					System.out.println("Error");
			} catch (SQLException e) {
				System.out.println("Lỗi trong quá trình DELETE\n" + e.getMessage());
			}
		}
	public static void main(String[] args) {
		getSVCNTTT();
		soSinhVienTheoNganh();
		getSinhVienDTBMax();
//		nganhInsert();
//		getNganhDaoTao();
//		nganhDelete();
		getNganhDaoTao();
	}

}
