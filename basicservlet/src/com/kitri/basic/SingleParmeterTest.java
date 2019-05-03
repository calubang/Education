package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/singleparam")
public class SingleParmeterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. data get
		String name = request.getParameter("name");
		
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//2. data logic
		String color = (age == 10  ? "pink" : "cyan");
		
		
		//3. response page : 이름(id)님 안녕하세요. 
		//10대 미만은 아이디 빨강
		//이상은 아이디 파랑
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<h3>");
		printWriter.println(name + "(" +"<font color='" + color + "'>" + id + "</font>" + ")님 안녕하세요.");		
		printWriter.println("</h3>");
		printWriter.println("</body>");
		printWriter.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식에서는 request 의 인코딩방식을 정해주어야 한다.
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
	}

}
