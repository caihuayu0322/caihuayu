package com.incito.socket.test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test3 extends JFrame implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6641568421296461034L;
	
	private JPanel  test;
	private JTextField input,output;
	private JLabel inputLabel,outputLabel;
	private JButton button;
	
	public Test3(){
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		test = new JPanel();
//		test.setSize(500, 500);
		test.setLayout(null);
		this.setContentPane(test);
		
		inputLabel  = new JLabel("二进制码：");
		inputLabel.setBounds(50, 100, 100, 50);
		test.add(inputLabel);
		
		input = new JTextField();
		input.setBounds(150, 100, 300, 50);
		test.add(input);
		
		outputLabel = new JLabel("输出：");
		outputLabel.setBounds(50, 200, 300, 100);
		test.add(outputLabel);
		
		output = new JTextField();
		output.setBounds(150, 200, 300, 100);
		test.add(output);
		
		button = new JButton("确定");
		button.setBounds(230, 350, 80, 30);
		button.addMouseListener(this);
		test.add(button);
		
		this.setVisible(true);
	}
	public static  void main(String args[]) {
		new Test3();
	}
//	  private String BinstrToStr(String binStr) {
//	        String[] tempStr=StrToStrArray(binStr);
//	        char[] tempChar=new char[tempStr.length];
//	        for(int i=0;i<tempStr.length;i++) {
//	            tempChar[i]=BinstrToChar(tempStr[i]);
//	        }
//	        return String.valueOf(tempChar);
//	    }
	    //将初始二进制字符串转换成字符串数组，以空格相隔
	    private String[] StrToStrArray(String str) {
//	    	for (int i = 0; i < str.split("").length; i++) {
//				String[]a = str.split("");
//	    		System.out.print(a);
//				
//			}
	        return str.split(" ");
	    }
	    //将二进制字符串转换为char
	    private char BinstrToChar(String binStr){
	        int[] temp=BinstrToIntArray(binStr);
	        int sum=0;   
	        for(int i=0; i<temp.length;i++){
	            sum +=temp[temp.length-1-i]<<i;
	        }   
	        return (char)sum;
	    }
	    //将二进制字符串转换成int数组
	    private int[] BinstrToIntArray(String binStr) {       
	        char[] temp=binStr.toCharArray();
	        int[] result=new int[temp.length];   
	        for(int i=0;i<temp.length;i++) {
	            result[i]=temp[i]-48;
	        }
	        return result;
	    }
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(button)){
			String sourse = input.getText();
	        String[] tempStr=StrToStrArray(sourse);
	        char[] tempChar=new char[tempStr.length];
	        for(int i=0;i<tempStr.length;i++) {
	            tempChar[i]=BinstrToChar(tempStr[i]);
	        }
	        String a = String.valueOf(tempChar);
	        output.setText(a);
		}
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
