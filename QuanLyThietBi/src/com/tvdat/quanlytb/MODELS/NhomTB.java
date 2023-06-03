package com.tvdat.quanlytb.MODELS;

public class NhomTB {
	private String maNhom;
	private String tenNhom;
	
	public NhomTB(String maNhom, String tenNhom) {
		this.maNhom = maNhom;
		this.tenNhom = tenNhom;
	}
	public String displayNhomTB() {
//		return this.productID + "\t\t" + this.nameProduct + "\t\t" + this.price + "\t" + this.quantity + "\t" + this.categoryID;
		String formatString = String.format("%-7s %s ", this.maNhom, this.tenNhom);
		return formatString;
	}
}
