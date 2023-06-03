package com.tvdat.shape;

public class HinhTamGiac extends Hinh {
	private double a, b, c;
	public HinhTamGiac(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public String getLoai() {
		return "TG";
	}

	@Override
	public double getChuVi() {
		return (this.a + this.b + this.c);
	}

	@Override
	public String getThongTin() {
		return this.a + "," + this.b + "," + this.c;
	}

}
