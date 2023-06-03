package htai.com.thihk.MODELS;

public class GiaoVien extends Person{
	private int phuCap;
	public GiaoVien(String maNhanvien, String hoTen, String loaiHopDong, int heSoLuong, int phuCap) {
		super(maNhanvien, hoTen, loaiHopDong, heSoLuong);
		this.phuCap = phuCap;
	}
	
	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public String getGiaoVien() {
		return getMaNhanVien() + "\t" + getHoTen() + "\t" + getLoaiHopDong() + "\t" + getHeSoLuong() + "\t" + this.phuCap;
	}
}
