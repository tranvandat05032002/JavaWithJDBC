package com.tvdat.models;

public class infoXeRa {
	private int loaiXe;
	private String bienSo;
	private String soVe;
	private String thoiGianRa;
	private String trangThaiRa;
	public infoXeRa(int loaiXe, String bienSo, String soVe, String thoiGianRa, String trangThaiRa) {
		this.loaiXe = loaiXe;
		this.bienSo = bienSo;
		this.soVe = soVe;
		this.thoiGianRa = thoiGianRa;
		this.trangThaiRa = trangThaiRa;
	}
	public int getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(int loaiXe) {
		this.loaiXe = loaiXe;
	}
	public String getBienSo() {
		return bienSo;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	public String getSoVe() {
		return soVe;
	}
	public void setSoVe(String soVe) {
		this.soVe = soVe;
	}
	public String getThoiGianRa() {
		return thoiGianRa;
	}
	public void setThoiGianRa(String thoiGianRa) {
		this.thoiGianRa = thoiGianRa;
	}
	public String getTrangThaiRa() {
		return trangThaiRa;
	}
	public void setTrangThaiRa(String trangThaiRa) {
		this.trangThaiRa = trangThaiRa;
	}
	
}
