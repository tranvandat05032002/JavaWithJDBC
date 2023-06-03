package com.tvdat.quanlytb.MODELS;

import java.time.LocalDate;

public class ThietBi {
	private String maNhom;
	private String maTB;
	private String tenTB;
	private String ngaySanXuat;
	private int gia;
	
	public ThietBi(String maNhom, String maTB, String tenTB, String ngaySanXuat ,int gia) {
		this.maNhom = maNhom;
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.ngaySanXuat = ngaySanXuat;
		this.gia = gia;
	}
	public String displayTB() {
		String formatString = String.format("%-7s %-7s %-23s %-15s %d", this.maNhom, this.maTB, this.tenTB, this.ngaySanXuat, this.gia);
		return formatString;
	}
}
