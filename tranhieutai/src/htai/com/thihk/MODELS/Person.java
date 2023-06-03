package htai.com.thihk.MODELS;

public class Person {
	private String maNhanVien;
	private String hoTen;
	private String loaiHopDong;
	private int heSoLuong;
	
	public Person(String maNhanvien, String hoTen, String loaiHopDong, int heSoLuong) {
		this.maNhanVien = maNhanvien;
		this.hoTen = hoTen;
		this.loaiHopDong = loaiHopDong;
		this.heSoLuong = heSoLuong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLoaiHopDong() {
		return loaiHopDong;
	}

	public void setLoaiHopDong(String loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}

	public int getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	
}
