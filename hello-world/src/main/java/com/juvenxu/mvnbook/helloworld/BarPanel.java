package com.juvenxu.mvnbook.helloworld;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;

public class BarPanel extends JPanel {
	JButton buttonOK;
	FlowLayout flowLayout;
	JButton buttonQuit;

	public BarPanel(JFrame context, int startX, int startY) {
		setBounds(startX, startY, 267, 50);
		flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		setBackground(null);
		setLayout(flowLayout);
		buttonOK = new JButton();
		buttonOK.setForeground(Color.BLUE);
		buttonOK.setFont(new Font("宋体", Font.BOLD, 12));
		Icon iconComfirm = new ImageIcon("/image/a.jpg");
		buttonOK.setIcon(iconComfirm);
		buttonOK.setBorderPainted(false);// 设置边框不可见
		buttonOK.setContentAreaFilled(false);// 设置透明
//		buttonOK.setPressedIcon(new ImageIcon(SCREEN_SHOT_CONFIRM_HOVER));
		buttonOK.setSize(iconComfirm.getIconWidth(),
				iconComfirm.getIconHeight());
		add(buttonOK);
//		buttonOK.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				sendPaper();
//			}
//		});
		buttonQuit = new JButton();
		buttonQuit.setForeground(Color.BLUE);
		buttonQuit.setFont(new Font("宋体", Font.BOLD, 12));
		add(buttonQuit);
		Icon iconQuit = new ImageIcon("image/b.jpg");
		buttonQuit.setIcon(iconQuit);
		buttonQuit.setSize(iconQuit.getIconWidth(),
				iconQuit.getIconHeight());
		buttonQuit.setBorderPainted(false);// 设置边框不可见
		buttonQuit.setContentAreaFilled(false);// 设置透明
//		buttonQuit
//				.setPressedIcon(new ImageIcon(SCREEN_SHOT_QUIT_HOVER));
//		buttonQuit.addActionListener(new ActionListener() {

//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Application.hasQuiz = false;
//				Application.getInstance().getFloatIcon().synQuzingState();
//				MainFrame.getInstance().synQuzingState();
//				MainFrame.getInstance().showNoQuiz();
//				Application.getInstance().getFloatIcon().showNoQuiz();
//				updates();
//				jf.dispose();
//				isBarShow = false;
//
//			}
//		});
		context.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
		new BarPanel(frame, 100, 100);
	}
}
