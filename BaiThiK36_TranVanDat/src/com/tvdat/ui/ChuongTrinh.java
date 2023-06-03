package com.tvdat.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import con.tvdat.DAO.xe0BanhDAO;
import con.tvdat.DAO.xe2BanhDAO;
import con.tvdat.DAO.xe4BanhDAO;

import com.tvdat.models.infoXeRa;
import com.tvdat.models.infoXeVao;

public class ChuongTrinh {
//--
	static String handleTienGuiXe(String dateVao, String dateRa, int maXe, String trangThaiRa) {
		String dateVaoSplit[] = dateVao.split(" ");
		String dateRaSplit[] = dateRa.split(" ");

		String timeVao[] = dateVaoSplit[0].split(":");
		String dayVao[] = dateVaoSplit[1].split("/");

		String timeRa[] = dateRaSplit[0].split(":");
		String dayRa[] = dateRaSplit[1].split("/");

		int soTien = 0;

		int ngayVao = Integer.parseInt(dayVao[0]);
		int ngayRa = Integer.parseInt(dayRa[0]);

		int gioVao = Integer.parseInt(timeVao[0]);
		int gioRa = Integer.parseInt(timeRa[0]);

		int phutVao = Integer.parseInt(timeVao[1]);
		int phutRa = Integer.parseInt(timeVao[1]);
		if (trangThaiRa.equals("Binh thuong") || trangThaiRa.equals("Not Avaliable")) {
			if (maXe == 0 || maXe == 2) {
				if (ngayRa - ngayVao > 0) {
					if (maXe == 0) {
						soTien = (ngayRa - ngayVao) * 1000;
					} else {
						soTien = (ngayRa - ngayVao) * 3000;
					}
				} else if (ngayRa - ngayVao <= 0 && phutRa - phutVao > 0 && gioRa - gioVao > 0) {
					if (maXe == 0) {
						soTien = (gioRa - gioVao + 1) * 1000;
					} else {
						soTien = (gioRa - gioVao + 1) * 3000;
					}
				} else if (ngayRa - ngayVao <= 0 && phutRa - phutVao == 0 && gioRa - gioVao > 0) {
					if (maXe == 0) {
						soTien = (gioRa - gioVao) * 1000;
					} else {
						soTien = (gioRa - gioVao) * 3000;
					}
				} else if (ngayRa - ngayVao <= 0 && phutRa - phutVao > 0 && gioRa - gioVao == 0) {
					if (maXe == 0) {
						soTien = 1 * 1000;
					} else {
						soTien = 1 * 3000;
					}
				}
			} else {
				if (phutRa - phutVao > 0) {
					soTien = (gioRa - gioVao) * 10000 + 5000;
				} else if (phutRa - phutVao == 0) {
					soTien = (gioRa - gioVao) * 10000;
				} else {
					soTien = ((gioRa - gioVao) * 10000) - 5000;
				}
			}
		} else {
			return "Chua xac dinh - Dang xu ly loi";
		}
		return String.valueOf(soTien);
	}

//--
	static ArrayList<infoXeVao> readFileInfoVao() {
		ArrayList<infoXeVao> listXeVao = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/spiderman/Desktop/Java/File/input.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				} else {
					String lineInfoXe[] = line.trim().split(";");
					for (int i = 0; i < lineInfoXe.length; i++) {
						int loaiXe = Integer.parseInt(lineInfoXe[0]);
						String bienSo = (lineInfoXe[1]).trim();
						String soVe = lineInfoXe[2].trim();
						String thoiGianVao = lineInfoXe[3].trim();
						String trangThaiXeVao = lineInfoXe[4].trim();

						infoXeVao xeVao = new infoXeVao(loaiXe, bienSo, soVe, thoiGianVao, trangThaiXeVao);
						listXeVao.add(xeVao);
						break;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listXeVao;
	}

//--
	static ArrayList<infoXeRa> readFileInfoRa() {
		ArrayList<infoXeRa> listXeRa = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/spiderman/Desktop/Java/File/input2.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				} else {
					String lineInfoXe[] = line.trim().split(";");
					for (int i = 0; i < lineInfoXe.length; i++) {
						int loaiXe = Integer.parseInt(lineInfoXe[0]);
						String bienSo = (lineInfoXe[1]).trim();
						String soVe = lineInfoXe[2].trim();
						String thoiGianRa = lineInfoXe[3].trim();
						String trangThaiXeRa = lineInfoXe[4].trim();

						infoXeRa xeRa = new infoXeRa(loaiXe, bienSo, soVe, thoiGianRa, trangThaiXeRa);
						listXeRa.add(xeRa);
						break;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listXeRa;
	}

//--
	private static void insertXeNBanh() {
		xe0BanhDAO xeDapDao = new xe0BanhDAO();
		xe2BanhDAO xeMayDao = new xe2BanhDAO();
		xe4BanhDAO xeOToDAO = new xe4BanhDAO();
		try {
			for (int i = 0; i < readFileInfoVao().size(); i++) {
				int getLoaiXeVao = readFileInfoVao().get(i).getLoaiXe();
				for (int j = 0; j < readFileInfoRa().size(); j++) {
					Random random = new Random();
					int randomNumber = random.nextInt(100000);
					int getLoaiXeRa = readFileInfoRa().get(j).getLoaiXe();
					if (getLoaiXeVao == 0 && getLoaiXeRa == 0) {
						boolean insertOK = xeDapDao.insertNewXe0Banh(String.valueOf(getLoaiXeVao + i + randomNumber),
								getLoaiXeVao, readFileInfoVao().get(i).getSoVe(),
								readFileInfoVao().get(i).getThoiGianVao(), readFileInfoRa().get(i).getThoiGianRa());
						if (insertOK)
							System.out.println("insert Successfully!!!");
						else
							System.out.println("Error");
					} else if (getLoaiXeVao == 2 && getLoaiXeRa == 2) {
						boolean insertOK = xeMayDao.insertXe2Banh(String.valueOf(getLoaiXeVao + i + randomNumber),
								getLoaiXeVao, readFileInfoVao().get(i).getBienSo(),
								readFileInfoVao().get(i).getThoiGianVao(), readFileInfoRa().get(i).getThoiGianRa());
						if (insertOK)
							System.out.println("insert Successfully!!!");
						else
							System.out.println("Error");
					} else if (getLoaiXeVao == 4 && getLoaiXeRa == 4) {
						boolean insertOK = xeOToDAO.insertXe4Banh(String.valueOf(getLoaiXeVao + i + randomNumber),
								getLoaiXeVao, readFileInfoVao().get(i).getBienSo(),
								readFileInfoVao().get(i).getThoiGianVao(), readFileInfoRa().get(i).getThoiGianRa(),
								readFileInfoVao().get(i).getTrangThaiXeVao(), readFileInfoRa().get(i).getTrangThaiRa());
						if (insertOK)
							System.out.println("insert Successfully!!!");
						else
							System.out.println("Error");
						break;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Lỗi trong quá trình INSERT\n" + e.getMessage());
		}
	}

	private static void hienThiVaTinhTien() {
		 try {
	            FileWriter writer = new FileWriter("/Users/spiderman/Desktop/Java/File/output.txt");
	            for (int i = 0; i < readFileInfoVao().size(); i++) {
	    			int getLoaiXeVao = readFileInfoVao().get(i).getLoaiXe();
	    			String getBienSo = readFileInfoVao().get(i).getBienSo();
	    			String getVeSoXe = readFileInfoVao().get(i).getSoVe();
	    			String thoiGianVao = readFileInfoVao().get(i).getThoiGianVao();
	    			for (int j = 0; j < readFileInfoRa().size(); j++) {
	    				String trangThaiRa = readFileInfoRa().get(i).getTrangThaiRa();
	    				String thoiGianRa = readFileInfoRa().get(i).getThoiGianRa();
	    				int getLoaiXeRa = readFileInfoRa().get(j).getLoaiXe();
	    				if(getLoaiXeRa == 0 &&  getLoaiXeVao == 0) {
	    					writer.write(String.valueOf(getLoaiXeVao + "," + getBienSo +
	    							"," + getVeSoXe + "," + thoiGianVao +
	    							"," + thoiGianRa + 
	    							"," + handleTienGuiXe(thoiGianVao, thoiGianRa, getLoaiXeRa, trangThaiRa) + "\n"));
	    					System.out.println("write success!");
	    				}
	    				else if(getLoaiXeRa == 2 && getLoaiXeVao == 2) {
	    					writer.write(String.valueOf(getLoaiXeVao + "," + getBienSo +
	    							"," + getVeSoXe + "," + thoiGianVao +
	    							"," + thoiGianRa + 
	    							"," + handleTienGuiXe(thoiGianVao, thoiGianRa, getLoaiXeRa, trangThaiRa) + "\n"));
	    					System.out.println("write success!");
	    				}
	    				else if(getLoaiXeRa == 4 && getLoaiXeVao == 4) {
	    					writer.write(String.valueOf(getLoaiXeVao + "," + getBienSo +
	    							"," + getVeSoXe + "," + thoiGianVao +
	    							"," + thoiGianRa + 
	    							"," + handleTienGuiXe(thoiGianVao, thoiGianRa, getLoaiXeRa, trangThaiRa) + "\n"));
	    					System.out.println("write success!");
	    					break;
	    				}
	    			}
	    		}
	            writer.close();
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
}

	public static void main(String[] args) {
		insertXeNBanh();
		hienThiVaTinhTien();
	}

}
