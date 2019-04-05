package com.kitri.io;

import java.io.*;

public class BufferedReaderTest {
	public static void main(String[] args) {
		
		//바로 문자열을 받는 방법
		BufferedReader in = null;
		BufferedReader fin = null;
		FileWriter fw = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("입력받을 file 의 이름을 써라 : ");
			
			String infile = in.readLine();
			System.out.println("infile 이름 : " + infile);
		
			System.out.print("복사할 파일이름 : ");
			String outFile = in.readLine();
			fw = new FileWriter(new File(outFile));
			fin = new BufferedReader(new InputStreamReader( new FileInputStream(new File(infile))));
			String str = null;
			while( (str = fin.readLine()) != null ){
				str = fin.readLine();
				fw.write(str + "\r\n");
				System.out.println(str);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fin != null) {
					fin.close();
				}
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
