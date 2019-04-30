package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int startDan = 2;
	private int endDan = 9;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//맨 위에 테이블 구조 생성
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(
				"<html>"
				+ "	<body>");
		writer.println(
				"<table>\r\n" + 
				"	<caption><a style=\"font-size: 15px; color: steelblue\" >구구단</a></caption>");
		//colgroup 설정
		writer.println("<colgroup>");
		for(int i=startDan ; i<= endDan ; i++) {
			if(i % 2 == 0) {
				writer.print("<col style='background-color:tomato;' width=\"100px\" >");
			} else {
				writer.print("<col style='background-color:steelblue;' width=\"100px\" >");
			}
		}
		writer.println("</colgroup>");
		
		//제일 위에 header 설정
		writer.println("<tr style=\"\r\n" + 
				"    text-align: center;\r\n" + 
				"    color: white;\r\n" + 
				"\">");
		for(int i = startDan; i <= endDan ; i++) {
			writer.print("<td >");
			writer.print(i + "단");
			writer.print("</td>");
		}
		writer.println("</tr>");
		
		//실제 구구단 
		for(int j = 1 ; j < 10 ; j++) {
			writer.println("<tr style=\"\r\n" + 
					"    text-align: center;\r\n" + 
					"    color: white;\r\n" + 
					"\">");
			for(int i=startDan ; i<=endDan ; i++) {
				writer.print("<td>");
				writer.print(i + "*" + j + " = " + (i * j));
				writer.println("</td>");
			}
			writer.println("</tr>");
		}
		
		writer.println("</table>");	
		writer.println(
				"	</body>"
				+ "</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
