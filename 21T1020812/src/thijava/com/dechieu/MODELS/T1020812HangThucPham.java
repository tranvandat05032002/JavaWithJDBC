package thijava.com.dechieu.MODELS;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class T1020812HangThucPham extends T1020812Hang {
	private String ngaySanXuat;
	private String ngayHetHan;
	public T1020812HangThucPham(String maHang, String tenHang, int soLuong, int donGia, int soLuongTonKho, String ngaySanXuat, String ngayHetHan) {
		super(maHang, tenHang, soLuong, donGia, soLuongTonKho);
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}
	@Override
	public void input() {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		super.input();
		System.out.println("1/1/2022 -> 31/12/2022");
		this.ngaySanXuat = scanner.next();
		System.out.println("1/1/2023 -> 31/12/2023");
		this.ngayHetHan = scanner.next();
	}
	public void print() {
		System.out.println(getMaHang() + "\t|" + getTenHang() + "\t|" + getSoLuong() + "\t|" + getDonGia() + "\t|" + getSoLuongTonKho() + "\t|" + this.ngaySanXuat + "\t|" + this.ngayHetHan );
	}
	public Date ChuanHoaDate(String ngayThangNam) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(ngayThangNam);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	public float VAT() {
		return (float) ((0.05 * getSoLuong()) * getDonGia());
	}
	public boolean HetHan() {
		LocalDate currentDate = LocalDate.now();
		String[] ngayThangNam = this.ngayHetHan.split("/"); 
		int day = Integer.parseInt(ngayThangNam[0]);
		int thang = Integer.parseInt(ngayThangNam[1]);
		int nam = Integer.parseInt(ngayThangNam[2]);
		LocalDate date2 = LocalDate.of(nam, thang, day);
		long diffInDays = ChronoUnit.DAYS.between(date2, currentDate);
		 if(diffInDays > 0) {
			 return true;
		 }
		 return false;
	}
	public String DanhGia() {
		int n = getSoLuong();
		if(getSoLuongTonKho() < getSoLuong() * 0.1) {
			return "Ban Nhanh";
		}
		else if(n * 0.1 < getSoLuongTonKho() && getSoLuongTonKho() < n * 0.3) {
			return "Ban Cham";
		}
		else {
			return "Kho Ban";
		}
	}
}
