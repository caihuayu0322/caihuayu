package com.juvenxu.mvnbook.helloworld;

import javax.swing.JFrame;

public class TestPackaging {
	JFrame a = new JFrame();
	TestPackaging(){
		a.setBounds(0, 0, 100, 200);
		a.setLocationRelativeTo(null);
		
		a.setVisible(true);
	}
	private void MAIN() {
		// TODO Auto-generated method stub
		new TestPackaging();
	}
}
