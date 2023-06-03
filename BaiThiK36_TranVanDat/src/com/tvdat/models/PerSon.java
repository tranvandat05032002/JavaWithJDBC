package com.tvdat.models;

public class PerSon {
	private String CMND;
	private String hoTen;
	private boolean gioiTinh;
	private int maSocanHo;
	public PerSon(String CMND, String hoTen, String gioiTinh, boolean newGioiTinh, int soCanHo) {
		this.CMND = CMND;
		this.hoTen = hoTen;
		this.gioiTinh = newGioiTinh;
		this.maSocanHo = soCanHo;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getMaSocanHo() {
		return maSocanHo;
	}
	public void setMaSocanHo(int maSocanHo) {
		this.maSocanHo = maSocanHo;
	}
	
}	
