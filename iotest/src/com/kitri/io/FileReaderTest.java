package com.kitri.io;

import java.io.*;

public class FileReaderTest {
	
	public static void main(String[] args) {
		
		
		FileReader reader = null;
		FileWriter writer = null;
		try {
			File infile = new File("D:\\iotest\\hello.txt");
			reader = new FileReader(infile);
			long length = infile.length();
			char c[] = new char[ (int)length ];
			int x = reader.read(c);
			
			System.out.println(x + "characters read!!!");
			String str = new String(c);
			System.out.println(str);
			
			File outFile = new File("D:\\\\iotest\\\\hello_copy2.txt");
			writer = new FileWriter(outFile);
			writer.write(str);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
				if(writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
