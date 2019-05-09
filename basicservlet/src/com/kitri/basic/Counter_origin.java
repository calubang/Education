package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter_origin")
public class Counter_origin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int cnt;
	int totalLen;
	
	public void init() {
		cnt = 0;
		totalLen = 8;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		String cntStr = cnt + "";//137
		int cntLen = cntStr.length();//3
		int zeroLen = totalLen - cntLen;//5
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은<br>");
		
		for(int i=0;i<zeroLen;i++)
			out.println("<img src=\"/basicservlet/img/0.png\" width=\"50\">");
		
		for(int i=0;i<cntLen;i++)
			out.println("<img src=\"/basicservlet/img/" + cntStr.charAt(i) + ".png\" width=\"50\">");
		
		out.println("<br>번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}


}
