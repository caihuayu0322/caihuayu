package com.incito.print;

import java.awt.Desktop;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.jar.Attributes;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class test {

	public void test(){
		File file = new File("");//获取选择的文件
		//构建打印请求属性集
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		//设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
		DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
		//查找所有的可用打印服务
		//PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		//定位默认的打印服务
		PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
//    PrintServiceLookup.lookupPrintServices(flavor, attributes)
		
		//显示打印对话框
		long j=Integer.parseInt("1");
		for(int i=0;i<j;i++)
		{
			try {
				DocPrintJob job = defaultService.createPrintJob(); //创建打印作业
				FileInputStream fis = new FileInputStream(file); //构造待打印的文件流
				DocAttributeSet das = new HashDocAttributeSet();
				Doc doc = new SimpleDoc(fis, flavor, das); //建立打印文件格式
				job.print(doc, pras); //进行文件的打印
			} catch(Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void test2(){
		File f = new File("xxxx.xxx");
		try {
			Desktop.getDesktop().print(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test3(){
		PrinterJob job = PrinterJob.getPrinterJob();
		PageFormat pf = job.defaultPage();
		Paper paper = new Paper();
		    double margin = 1; // half inch
		    paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
		        - margin * 2);
		    pf.setPaper(paper);
		job.setPrintable(new PrinterTemplate(vo, templateVO), pf);
		try {
		job.print();
		} catch (PrinterException e) {
		e.printStackTrace();
		}
	}
}
