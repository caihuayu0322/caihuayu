package com.juvenxu.mvnbook.helloworld;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingTest {
	private JFrame jframe;
	public SwingTest(){
		showUI();
	}
	private void showUI() {
		// TODO Auto-generated method stub
		jframe= new JFrame();
		jframe.setBounds(0, 0, 300, 400);
		jframe.setLocationRelativeTo(null);
		jframe.setUndecorated(true);
		jframe.setBackground(new Color(0, 0, 0, 0));
		
		 JTextField txt = new JTextField();
		txt.setBounds(0, 0, 50, 10);
		txt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				jframe.remove(txt);
				txt = new JPasswordField();
				txt.setBounds(0, 0, 50, 10);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jframe.add(txt);
		
		jframe.setVisible(true);
	}
	public static void main(String[] args) {
		new SwingTest();
	}
}
