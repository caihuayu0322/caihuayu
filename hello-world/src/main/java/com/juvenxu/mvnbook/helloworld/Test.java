package com.juvenxu.mvnbook.helloworld;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Test extends MouseAdapter{
	JFrame frame= new JFrame();
	public Test(){
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(3);
//		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		
		JPanel top = new JPanel();
		top.setSize(200, 39);
//		top.setOpaque(false);
		top.setBackground(Color.red);
		top.addMouseListener(this);
		frame.add(top);
		
		JButton minJbt=new JButton();
		minJbt.setSize(10, 20);
		minJbt.setBorderPainted(false);
//		minJbt.setContentAreaFilled(false);
		minJbt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Runtime.getRuntime().exec("cmd /c start http://www.baidu.com");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		top.add(minJbt);
		//链接
//		final JLabel linkLabel = new JLabel("链接");
//		linkLabel.setForeground(new Color(17, 136, 255));
//		linkLabel.setBounds(100, 200, 30, 30);
//		linkLabel.addMouseListener(new MouseListener() {
//			
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				linkLabel.setForeground(new Color(17, 136, 255));
////				try {
////					Runtime.getRuntime().exec("cmd /c start http://www.baidu.com");
////				} catch (IOException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//			}
//			
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				linkLabel.setForeground(new Color(144, 200, 255));
//			}
//			
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//			}
//			
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
////				JOptionPane.showMessageDialog(null,"xxx");
//				linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//				
//			}
//			
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
////			}
////		});
//		frame.add(linkLabel);
		
		UIManager.getDefaults().elements();
		
		JButton linkButton = new JButton("链接a");
		linkButton.setBorder(null);
		linkButton.setBorderPainted(false);
		linkButton.setBounds(100,100,50,30);
		frame.add(linkButton);
		
		//文本框加监听实现验证
		JTextField jt = new JTextField();
		jt.setBounds(10, 20, 100,30);
		jt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
//				if(Character.isDigit(c))
//					return;
				e.consume();
			}
		});
		frame.add(jt);
		
		frame.setVisible(true);	
	}
	public static void main(String[] args) {
		new Test();
		
	}
	
}
