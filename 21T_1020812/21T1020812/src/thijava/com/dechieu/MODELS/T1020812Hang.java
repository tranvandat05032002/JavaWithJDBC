package thijava.com.dechieu.MODELS;

import java.util.Scanner;

public class T1020812Hang {
	private String maHang;
	private String tenHang;
	private int soLuong;
	private int donGia;
	private int soLuongTonKho;
	public T1020812Hang(String maHang, String tenHang, int soLuong,int donGia, int soLuongTonKho) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.soLuongTonKho = soLuongTonKho;
	}
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("maHang: 3 ky tu in hoa A -> Z: ");
		this.maHang = scanner.next();
		System.out.println("DienMay: {MayTinh, DieuHoa, QuatDien, MayGiat}; ThucPham: {MyTom, TraiCay, BanhKeo, NuocNgot} ");
		this.tenHang = scanner.next();
		System.out.println("SoLuong: 10 -> 100: ");
		this.soLuong = scanner.nextInt();
		System.out.println("donGia: 10 -> 500");
		this.donGia = scanner.nextInt();
		System.out.println("SoLuongTonKho: 0 -> soLuong");
		this.soLuongTonKho = scanner.nextInt();
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}
	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}
	
	
}
