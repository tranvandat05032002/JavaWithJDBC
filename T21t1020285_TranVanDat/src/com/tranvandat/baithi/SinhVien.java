package com.tranvandat.baithi;

public class SinhVien {
	private String maSinhVien;
	private String hoDem;
	private String ten;
	private boolean gioiTinh;
	private String ngaySinh;
	private int maNganh;
	private double diemTrungBinh;
	
	public SinhVien(String maSinhVien, String hoDem, String ten, boolean gioiTinh, String ngaySinh, int maNganh, double diemTrungBinh) {
		this.maSinhVien = maSinhVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.maNganh = maNganh;
		this.diemTrungBinh = diemTrungBinh;
	}
	public int getMaNganh() {
		return this.maNganh;
	}
	public double getDTB() {
		return this.diemTrungBinh;
	}
	public String getHoDem() {
		return this.hoDem;
	}
	public String getTen() {
		return this.ten;
	}
	public String getMaSinhVien() {
		return this.maSinhVien;
	}
	public String formatGioiTinh(boolean gioiTinh) {
		String resultGioiTinh = gioiTinh ? "Nu" : "Nam";
		return resultGioiTinh;
	}
	public String getThongTinCNTT() {
		return this.maSinhVien + "\t\t" + this.hoDem + " " + this.ten + "\t\t" + formatGioiTinh(this.gioiTinh) + "\t\t" + this.ngaySinh;
	}
}
