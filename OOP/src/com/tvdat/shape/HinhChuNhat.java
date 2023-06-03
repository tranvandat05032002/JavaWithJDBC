package com.tvdat.shape;

public class HinhChuNhat extends Hinh {
	private double a;
	private double b;
	public HinhChuNhat(double a, double b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public String getLoai() {
		return "CN";
	}

	@Override
	public double getChuVi() {
		return (this.a + this.b) * 2;
	}

	@Override
	public String getThongTin() {
		return this.a + "x" + this.b;
	}

}
