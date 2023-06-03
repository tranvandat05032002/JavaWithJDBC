package thijava.com.dechieu.UI;

import java.util.ArrayList;
import java.util.Scanner;

import thijava.com.dechieu.MODELS.T1020812HangDienTu;
import thijava.com.dechieu.MODELS.T1020812HangThucPham;

public class T1020812ChuongTrinh {
//cau1_a
	public void inHang() {
		T1020812HangThucPham htp = new T1020812HangThucPham("ABC", "TraiCay", 60, 70, 50, "23/4/2022", "31/5/2022");
		htp.print();
		System.out.println(htp.VAT());
		System.out.println(htp.HetHan());
		System.out.println(htp.DanhGia());
		T1020812HangDienTu hdt = new T1020812HangDienTu("BCD", "MayGiat", 13, 300 , 6, 42, "23/4/2022");
		System.out.println(hdt.VAT());
		System.out.println(hdt.HetHan());
		System.out.println(hdt.DanhGia());
	}
//cau2
	public static void main(String[] args) {
		T1020812ChuongTrinh ct = new T1020812ChuongTrinh();
		ct.inHang();
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		ArrayList<T1020812HangThucPham> listTP = new ArrayList<>();
		ArrayList<T1020812HangDienTu> listDT = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			T1020812HangThucPham htp = new T1020812HangThucPham(null, null, n, i, n, null, null);
			htp.input();
			listTP.add(htp);
		}
		for(int i = 0; i < n; i++) {
			T1020812HangDienTu hdt = new T1020812HangDienTu(null, null, n, i, n, n, null);
			hdt.input();
			listDT.add(hdt);
		}
	}

}
