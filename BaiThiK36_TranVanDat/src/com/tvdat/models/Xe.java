package com.tvdat.models;

public class Xe {
	private String mauSon;
	private String hangSanXuat;
	
	public Xe(String mauSon, String hangSanXuat) {
		this.mauSon = mauSon;
		this.hangSanXuat = hangSanXuat;
	}

	public String getMauSon() {
		return mauSon;
	}

	public void setMauSon(String mauSon) {
		this.mauSon = mauSon;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	
}
