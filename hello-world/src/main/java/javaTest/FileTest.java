package javaTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
	File test = new File("test.txt");
	test.delete();
	try {
		test.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String sets = "attrib +H \"" + test.getAbsolutePath() + "\"";  
	// 输出命令串  
	System.out.println(sets);  
	// 运行命令串  
	try {
		Runtime.getRuntime().exec(sets);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FileOutputStream os = null;
	try {
		os = new FileOutputStream(test);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String a = "hello!";
	try {
		os.write(a.getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
