package com.tvdat.shape;

public class HinhTron extends Hinh {
	private double banKinh;
	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public String getLoai() {
		return "HinhTron";
	}

	@Override
	public double getChuVi() {
		return 3.14 * this.banKinh * 2;
	}

	@Override
	public String getThongTin() {
		return "BK" + this.banKinh;
	}

}
