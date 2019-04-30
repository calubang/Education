package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	//무시해도 되는 부분
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 데이터 받아라
		// 2. 로직 처리 
		// 3. 응답 page html 만들기
		/*	<html>
		 * 		<body>
		 * 			hello Servlet!!!
		 * 		</body>
		 * </html>
		 * 
		 * */
		//
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println(
				"<html>\r\n" + 
				"		  		<body>\r\n" + 
				"		  			hello Servlet!!!<br>\r\n" +
				"                   안녕 Servlet!!!!\r\n" +
				"		  		</body>\r\n" + 
				"		</html>");
		
	}

}
