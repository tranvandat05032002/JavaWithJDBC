package com.tvdat.models;

public class Xe4Banh extends infoXeVao {

	public Xe4Banh(int loaiXe, String bienSo, String soVe, String thoiGianVao, String trangThaiVao) {
		super(loaiXe, bienSo, soVe, thoiGianVao, trangThaiVao);
	}
	public void formatLoaiXe() {
		setSoVe("");
	}
}
