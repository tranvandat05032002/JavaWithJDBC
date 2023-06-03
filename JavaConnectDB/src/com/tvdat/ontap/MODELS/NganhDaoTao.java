package com.tvdat.ontap.MODELS;

public class NganhDaoTao {
	private int maNganh;
	private String tenNganh;
	
	public NganhDaoTao(int maNganh, String tenNganh) {
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
	}
	public int getMaNganh() {
		return this.maNganh;
	}
	public String getTenNganh() {
		return this.tenNganh;
	}
	public String getThongTin() {
		return this.maNganh + "\t" + this.tenNganh;
	}
}
