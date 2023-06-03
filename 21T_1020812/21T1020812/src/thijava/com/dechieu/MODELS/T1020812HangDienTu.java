package thijava.com.dechieu.MODELS;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class T1020812HangDienTu extends T1020812Hang {
	private int thoiGianBaoHanh;
	private String ngaySanXuat;
	public T1020812HangDienTu(String maHang, String tenHang, int soLuong, int donGia, int soLuongTonKho, int ngayBaoHanh, String ngaySanXuat) {
		super(maHang, tenHang, soLuong, donGia, soLuongTonKho);
		this.thoiGianBaoHanh = ngayBaoHanh;
		this.ngaySanXuat = ngaySanXuat;
	}
	@Override
	public void input() {
		Scanner scanner = new Scanner(System.in);
		super.input();
		System.out.println("24 -> 72");
		this.thoiGianBaoHanh = scanner.nextInt();
		System.out.println("1/1/2022 -> 31/12/2022");
		this.ngaySanXuat = scanner.next();
	}
	public void print() {
		System.out.println(getMaHang() + "\t|" + getTenHang() + "\t|" + getSoLuong() + "\t|" + getDonGia() + "\t|" + getSoLuongTonKho() + "\t|" + this.thoiGianBaoHanh + "\t|" + this.ngaySanXuat);
	}
	public double VAT() {
		return (double) ((0.1 * (double)getSoLuong()) * (double)getDonGia());
	}

	public boolean HetHan() {
		LocalDate currentDate = LocalDate.now();
		String[] ngayThangNam = this.ngaySanXuat.split("/"); 
		int day = Integer.parseInt(ngayThangNam[0]);
		int thang = Integer.parseInt(ngayThangNam[1]);
		int nam = Integer.parseInt(ngayThangNam[2]);
		LocalDate date2 = LocalDate.of(nam, thang, day);
		long diffInDays = ChronoUnit.DAYS.between(date2, currentDate);
		 if(diffInDays > 2 * this.thoiGianBaoHanh) {
			 return true;
		 }
		 return false;
	}
	public String DanhGia() {
		int n = getSoLuong();
		if(getSoLuongTonKho() < getSoLuong() * 0.2) {
			return "Ban Nhanh";
		}
		else if(n * 0.2 < getSoLuongTonKho() && getSoLuongTonKho() < n * 0.5) {
			return "Ban Duoc";
		}
		else if(n * 0.5 < getSoLuongTonKho() && getSoLuongTonKho() < n * 0.7) {
			return "Ban Cham";
		}
		else {
			return "Kho Ban";
		}
	}
}
