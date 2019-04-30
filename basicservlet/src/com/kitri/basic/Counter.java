package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int cnt = 0;
	private static final int max = 8;
	
	private String src = "/basicservlet/img/";
	
	//init()
	//디비 드라이버 로딩
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		
		String count = String.format(("%0"+ max+ "d") , cnt);	
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은 ");
		
		for(int i = 0 ; i<count.length() ; i++) {
			out.print("<img src='"+ src + count.charAt(i) + ".png" +  "' width='50' height='50'>");
		}
		
		out.println(count);
		out.println("번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
