package com.juvenxu.mvnbook.helloworld;


import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.TextUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.View;
import javax.swing.text.Position.Bias;

import com.sun.java.swing.plaf.windows.resources.windows;

public class TestSwing {
	public JFrame frame = new JFrame();

	private TestSwing(){
		setUI();
	}
	private void setUI(){
		frame.setBounds(0, 0, 300, 300);
		frame.setLocationRelativeTo(null);
		
		JTextField jt = new JTextField();
		jt.setBounds(0, 0, 20, 10);
//		jt.setBackground(Color.red);
		
		frame.add(jt);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new TestSwing();
	}
}
