package com.incito.swing.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.awt.AWTUtilities;

public  class Test1 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7268113856580343170L;
	JPanel pane ;
	JButton button;
	JTextField text;
	JLabel label;
	public Test1(){
		setSize(200, 300);
		setLocationRelativeTo(null);
//		getContentPane().setBackground(Color.black);//如果没有这句的默认继承父辈的backgroud，默认是灰色的
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);//一直在前
		setUndecorated(true);
		setLayout(null);//绝对布局
//		AWTUtilities.setWindowOpacity(this, 0.5f);//设置透明管，必须undecorated
		JDialog dialog = new JDialog();
//		GraphicsConfiguration gc= this.getGraphicsConfiguration();
//		add(new Test2(){
//			private static final long serialVersionUID = -7316326383701653011L;
//
//			@Override
//			public void setBounds(int x, int y, int width, int height) {
//				// TODO Auto-generated method stub
//				super.setBounds(10, 20, 30, 50);
//			}
//		});
		pane = new JPanel();
		pane.setBounds(20, 30, 50, 30);	
//		pane.setBackground(new Color(100,100, 100, 100));设置透明度，前三位是红绿蓝，最后一位是透明度，0-255之间一个字节
		add(pane);
		
		button = new JButton();
		button.setBounds(20, 100, 100, 50);
//		button.setFocusable(false);
		button.setBackground(Color.red);
		button.setContentAreaFilled(false);//清空内部填充
//		button.setBorderPainted(false);
		button.setIcon(new Icon() {//icon是个接口
			
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getIconWidth() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getIconHeight() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		add(button);
		
//		toFront();//把窗口显示到其他窗口之前
//		toBack();//把窗口放到后面
		text = new JTextField(){//绘制图片
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
//				this.paintComponent(g);
				super.paintComponent(g);//注意要将super.paint放在上面，防止覆盖绘制
				g.drawImage(new ImageIcon("image/bg_qa.png").getImage(), 0, 0, null);//x,y指的是本容器的大小
			}
		};
		text.setBounds(10, 150, 128, 48);
//		text.paint(getGraphics());
//		text.addActionListener(new ActionListener() {//不起作用，为什么？
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				text.setText("hello");
//			}
//		});
//		text.setFocusable(false);
		add(text);
		
		JLabel 
		label = new JLabel("111");
		label.setBounds(100, 200, 40, 40);
		label.setForeground(Color.red);//字体的颜色
		Graphics gfc=getGraphics();
		Rectangle a = label.getBounds();
//		a.setSize(60, 60);
		add(label);
		
		setVisible(true);
	}
	/**
	 * 内部类
	 * @author JHON
	 *
	 */
	public class Test2 extends JPanel{
		private static final long serialVersionUID = -392632678899736746L;

		public Test2(){
			setUndecorated(true);
			setSize(50,50);
			getContentPane().setBackground(Color.red);
		}
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
