package com.tvdat.quanlytb.UI;

import java.util.ArrayList;
import java.util.Scanner;

import com.tvdat.quanlytb.DAO.NhomTBDAO;
import com.tvdat.quanlytb.DAO.ThietBiDAO;
import com.tvdat.quanlytb.MODELS.NhomTB;
import com.tvdat.quanlytb.MODELS.ThietBi;

public class ChuongTrinh {
	public void getThietBi() {
		ThietBiDAO dao = new ThietBiDAO();
		ArrayList<ThietBi> listTB = dao.getTableTBDatabase();
		System.out.println("MaNhom\tMaTB\tTenTB\t\t\tNgaySanXuat\tGia");
		for(int i = 0; i < listTB.size(); i++) {
			ThietBi x = listTB.get(i);
			System.out.println(x.displayTB());
		}
	}
	public void getNhomTB() {
		NhomTBDAO dao = new NhomTBDAO();
		ArrayList<NhomTB> listNTB = dao.getNhomTBDatabase();
		System.out.println("MaNhom\tTenNhom");
		for(int i = 0; i < listNTB.size(); i++) {
			NhomTB ntb = listNTB.get(i);
			System.out.println(ntb.displayNhomTB());
		}
	}
	public static void main(String[] args) {
		ChuongTrinh ct = new ChuongTrinh();
//		ct.getThietBi();
//		ct.getNhomTB();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap table can hien thi:");
		System.out.println("1: Table Nhom Thiet Bi; 2: Table Thiet Bi");
		int n = scanner.nextInt();
		if(n == 1) {
			ct.getNhomTB();
		}
		else if(n == 2) {
			ct.getThietBi();
		}
	}
}
