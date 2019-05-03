package com.kitri.basic;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.accessibility.internal.resources.accessibility;

@WebServlet("/filecounter")
public class FileCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static File counterFile = null;
	
	@Override
	public void init() throws ServletException {
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파일 읽어오기
		//2. 카운터 1증가
		//3. 파일에 쓰기
		counterFile = new File(getServletContext().getRealPath("counter.txt"));
		RandomAccessFile accessFile = new RandomAccessFile(counterFile, "rw");
		//int temp = accessFile.;
			
		//temp = temp.trim();
		//System.out.println(temp);
		//int count2 = Integer.parseInt(temp2);
		//String temp2 = "160";
//		reader.close();
//		count++;
//		
//		System.out.println(count);
//		FileWriter fileWriter = new FileWriter(counter);
//		fileWriter.write(count);
//		fileWriter.close();
//	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
