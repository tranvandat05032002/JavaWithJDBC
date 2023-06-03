package com.tvdat.shape;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChuongTrinh {
	static void inDanhSach(ArrayList<Hinh>lst) {
		System.out.println("STT\tLoại\tChu vi\tThông tin");
		int stt = 0;
		for (int i = lst.size() - 1; i >= 0; i--) {
			stt++;
			Hinh x = lst.get(i);
			System.out.println(stt + "\t" + x.getLoai() + "\t" + x.getChuVi() + "\t" + x.getThongTin());
		}
	}
	static Hinh getFromLine(String line) {
		String lineTrim = line.trim();
		String[] element = lineTrim.split(";");
		if(element[0].equals("1")) {
			double bk = Double.parseDouble(element[1]);
			return new HinhTron(bk);
		}
		else {
			return null;
		}
	}
	static ArrayList<Hinh> redFile(String fileName){
		ArrayList<Hinh>lst = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				Hinh x = getFromLine(line);
				lst.add(x);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	static void show() {
		ArrayList <Hinh> lst = redFile("/Users/spiderman/Desktop/Java/File/hinh.txt");
		inDanhSach(lst);
		System.out.println();
	}
	public static void main(String[] args) {
		show();
	}
}
