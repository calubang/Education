package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Basic
 */
@WebServlet("/basic")
public class Basic extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public String name;
	public int age;
	
	@Override
	public void init() throws ServletException {
		name = "고먐미";
		age = 17;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		
		String fontColor = "";
		if(age < 19) {
			fontColor = "red";
		}else {
			fontColor = "steelblue";
		}
		
		out.println("<font color=\""+ fontColor + "\">" + name + "님("+ age + ")안녕하세요</font>");
		out.println("	</body>");
		out.println("</html>");
		
	}

}
