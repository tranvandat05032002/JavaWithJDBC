package com.tvdat.models;

public class infoXeVao {
	private int loaiXe;
	private String bienSo;
	private String soVe;
	private String thoiGianVao;
	private String trangThaiXeVao;
	public infoXeVao(int loaiXe, String bienSo, String soVe, String thoiGianVao, String trangThaiVao) {
		this.loaiXe = loaiXe;
		this.bienSo = bienSo;
		this.soVe = soVe;
		this.thoiGianVao = thoiGianVao;
		this.trangThaiXeVao = trangThaiVao;
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
	public String getThoiGianVao() {
		return thoiGianVao;
	}
	public void setThoiGianVao(String thoiGianVao) {
		this.thoiGianVao = thoiGianVao;
	}
	public String getTrangThaiXeVao() {
		return trangThaiXeVao;
	}
	public void setTrangThaiXeVao(String trangThaiXeVao) {
		this.trangThaiXeVao = trangThaiXeVao;
	}
	public String getThongTinXeVao() {
		return this.loaiXe + ", " + this.bienSo + ", " + this.soVe + ", " + this.thoiGianVao + ", " + this.trangThaiXeVao;
	}
}
