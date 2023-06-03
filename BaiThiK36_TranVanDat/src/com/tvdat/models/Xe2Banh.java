package com.tvdat.models;

public class Xe2Banh extends infoXeVao {

	public Xe2Banh(int loaiXe, String bienSo, String soVe, String thoiGianVao, String trangThaiVao) {
		super(loaiXe, bienSo, soVe, thoiGianVao, trangThaiVao);
	}
	public void formatLoaiXe() {
		setSoVe("");
		setTrangThaiXeVao("");
	}
}
