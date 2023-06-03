package htai.com.thihk.UI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import htai.com.thihk.DAO.GiaoVienDAO;
import htai.com.thihk.DAO.NhanVienDAO;
import htai.com.thihk.MODELS.GiaoVien;
import htai.com.thihk.MODELS.NhanVien;

public class ChuongTrinh {
	public void displayFileToKetQua() {
//		ArrayList<NhanVien> listNhanvien = new ArrayList<>();
//		ArrayList<GiaoVien> listGiaoVien = new ArrayList<>();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/spiderman/Desktop/Code/Java/File/ketqua.txt"))){
			BufferedReader br = new BufferedReader(new FileReader("/Users/spiderman/Desktop/Code/Java/File/ds.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null || line == "") {
					break;
				} else {
					ArrayList<String>listString = new ArrayList <>();
					String linePerson[] = line.trim().split(" ");
					for(int i = 0; i < linePerson.length; i++) {
						System.out.print(linePerson[i] + " ");
						writer.write((linePerson[i] + " "));	
					}
					writer.write(("\n"));
					System.out.println();
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<NhanVien> readfileKetQuaNhanVien() {
		ArrayList<NhanVien> listNhanvien = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/spiderman/Desktop/Code/Java/File/ketqua.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null || line == "") {
					break;
				} else {
					String linePerson[] = line.trim().split(" ");
					if(linePerson.length == 4) {
						for(int i = 0; i < linePerson.length; i++) {
							String maNhanVien = linePerson[0].trim();
							String hoTen = linePerson[1].trim();
							String loaiHopDong = linePerson[2].trim();
							int heSoLuong = Integer.parseInt(linePerson[3]);
							
							NhanVien nv = new NhanVien(maNhanVien, hoTen, loaiHopDong, heSoLuong);
							listNhanvien.add(nv);
							break;
						}
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listNhanvien;
	}
	public ArrayList<GiaoVien> readfileKetQuaGiaoVien() {
		ArrayList<GiaoVien> listGiaoVien = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/spiderman/Desktop/Code/Java/File/ketqua.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null || line == "") {
					break;
				} else {
					String linePerson[] = line.trim().split(" ");
					if(linePerson.length == 5) {
						for(int i = 0; i < linePerson.length; i++) {
							String maNhanVien = linePerson[0].trim();
							String hoTen = linePerson[1].trim();
							String loaiHopDong = linePerson[2].trim();
							int heSoLuong = Integer.parseInt(linePerson[3]);
							int phuCap = Integer.parseInt(linePerson[4]);
							
							GiaoVien gv = new GiaoVien(maNhanVien, hoTen, loaiHopDong, heSoLuong, phuCap);
							listGiaoVien.add(gv);
							break;
						}
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listGiaoVien;
	}
	public void printListNhanVien() {
		System.out.println("Danh sach nhan vien: ");
		for(int i = 0; i < readfileKetQuaNhanVien().size(); i++) {
			NhanVien nv = readfileKetQuaNhanVien().get(i);
			System.out.println(nv.displayNhanVien());
		}
	}
	public void printListGiaoVien() {
		System.out.println("Danh sach giao vien: ");
		for(int i = 0; i < readfileKetQuaGiaoVien().size(); i++) {
			GiaoVien gv = readfileKetQuaGiaoVien().get(i);
			System.out.println(gv.getGiaoVien());
		}
	}
	public void nhanVienInsert() {
		NhanVienDAO dao = new NhanVienDAO();
		try {
			for(int i = 0; i < readfileKetQuaNhanVien().size(); i++) {
				boolean insertNhanVien = dao.insertNhanVien(readfileKetQuaNhanVien().get(i).getMaNhanVien(),readfileKetQuaNhanVien().get(i).getHoTen() , readfileKetQuaNhanVien().get(i).getLoaiHopDong(), readfileKetQuaNhanVien().get(i).getHeSoLuong());
				if(insertNhanVien) {
					System.out.println("Them nhan vien thanh cong");
				}
				else {
					System.out.println("Them nhan vien that bai");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void giaoVienInsert() {
		GiaoVienDAO dao = new GiaoVienDAO();
		try {
			for(int i = 0; i < readfileKetQuaGiaoVien().size(); i++) {
				boolean insertGiaoVien = dao.insertGiaoVien(readfileKetQuaGiaoVien().get(i).getMaNhanVien(),readfileKetQuaGiaoVien().get(i).getHoTen() , readfileKetQuaGiaoVien().get(i).getLoaiHopDong(), readfileKetQuaGiaoVien().get(i).getHeSoLuong(), readfileKetQuaGiaoVien().get(i).getPhuCap());
				if(insertGiaoVien) {
					System.out.println("Them giao vien thanh cong");
				}
				else {
					System.out.println("Them giao vien that bai");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getNhanVienChinhThuc() {
		NhanVienDAO dao = new NhanVienDAO();
		int countChinhThuc = dao.countChinhThuc();
		System.out.println(countChinhThuc);
		
	}
	public static void main(String[] args) {
		ChuongTrinh ct = new ChuongTrinh();
		ct.displayFileToKetQua();
		ct.printListNhanVien();
		ct.printListGiaoVien();
//		ct.nhanVienInsert();
//		ct.giaoVienInsert();
		ct.getNhanVienChinhThuc();
//		ct.readfileKetQua();
	}
}
