package com.incito.jxl.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jxl.CellFeatures;
import jxl.Workbook;
import jxl.biff.BaseCellFeatures;
import jxl.biff.DVParser;
import jxl.biff.DataValiditySettingsRecord;
import jxl.demo.Features;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class jan {

	public static void main(String[] args) {
		
		List names = new ArrayList();
		names.add("是");
		names.add("否");
		
		WritableCellFeatures wcf = new WritableCellFeatures();
		wcf.setComment("测试");
		wcf.setDataValidationRange(0, 0, 0, 1);
		wcf.setDataValidationList(names);
		
		File file = new File("E://ceshi//hello-world//file//model.xls");
		System.out.println(file.exists());
		try {
//			Workbook workbook = Workbook.getWorkbook(file);
			WritableWorkbook wwk = Workbook.createWorkbook(file);
			WritableSheet sheet = wwk.createSheet("测试", 0);
			Label lable = new Label(0, 0, "a");
			lable.setCellFeatures(wcf);
			sheet.addCell(lable);
			wwk.write();
			wwk.close();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
