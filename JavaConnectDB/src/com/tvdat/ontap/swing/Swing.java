package com.tvdat.ontap.swing;

import javax.swing.JFrame;

public class Swing {
	public Swing() {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
	public static void hienthi() {
		System.out.println("Hello");
	}
	public static void main(String[] args) {
		new Swing();
		hienthi();
	}
}
