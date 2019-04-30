package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hs")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println(
				"<html>\r\n" + 
				"		  		<body>\r\n" + 
				"		  			hello Servlet3.0!!!<br>\r\n" +
				"                   안녕 Servlet3.0!!!!\r\n" +
				"		  		</body>\r\n" + 
				"		</html>");
		
	}
	
	
}
