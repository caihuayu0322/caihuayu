package com.juvenxu.mvnbook.helloworld;

import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestFrame extends MouseAdapter{
	JFrame jframe = new JFrame();
	private TestFrame() {
		setUI();
	}
	
	private void setUI(){
		jframe.setSize(200, 300);
		jframe.setLocationRelativeTo(null);
		ImageIcon a = new ImageIcon("./image/a.jpg");
		jframe.setIconImage(a.getImage());
		jframe.setVisible(true);
		
		
		JLabel b = new JLabel(a);
		b.setBounds(0, 0, 200, 300);
		jframe.add(b);
		
	}
	public static void main(String[] args) {
		new TestFrame();
	}
}
