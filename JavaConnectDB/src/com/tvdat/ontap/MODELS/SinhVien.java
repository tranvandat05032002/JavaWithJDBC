package com.tvdat.ontap.MODELS;

public class SinhVien {
	private String maSinhVien;
	private String hoDem;
	private String ten;
	private boolean gioiTinh;
	private String ngaySinh;
	private String maNganh;
	private float diemTrungBinh;
	
	public SinhVien(String maSinhVien, String hoDem, String ten, boolean gioiTinh, String ngaySinh, String maNganh, float diemTrungBInh) {
		this.maSinhVien = maSinhVien;
		this.hoDem = hoDem;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.maNganh = maNganh;
		this.diemTrungBinh = diemTrungBInh;
	}
	
	
	public String getMaSinhVien() {
		return maSinhVien;
	}


	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}


	public String getHoDem() {
		return hoDem;
	}


	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public String getMaNganh() {
		return maNganh;
	}


	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}


	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}


	public void setDiemTrungBinh(float diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}


	public String formatGioiTinh(boolean gioiTinh) {
		String resultGioiTinh = gioiTinh ? "Nu" : "Nam";
		return resultGioiTinh;
	}
	public String getThongTinCNTT() {
		return this.maSinhVien + "\t\t" + this.hoDem + " " + this.ten + "\t\t" + formatGioiTinh(this.gioiTinh) + "\t\t" + this.ngaySinh;
	}
}
