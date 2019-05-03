package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam")
public class MultiParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age  = Integer.parseInt(request.getParameter("age"));
		String fruits[] = request.getParameterValues("fruits");
		
		//로직
		String color = (age == 10 ? "pink" : "cyan");
		String likeFruit = "";
		if(fruits == null) {
			likeFruit = "없습니다.";
		} else{
			int length = fruits.length;
			for(int i =0 ; i<length ; i++) {
				likeFruit += "<font color='";
				switch (fruits[i]) {
					case "사과":
						likeFruit += "#9a464c";
						break;
					case "바나나":
						likeFruit += "#ffe774";
						break;
					case "수박":
						likeFruit += "green";
						break;
					case "딸기":
						likeFruit += "#ffbaab";
						break;
					default:
						break;
				}
				likeFruit += "'>";
				likeFruit += fruits[i];
				likeFruit += "</font>";
				if(i < length-1)
					likeFruit += ", ";
			}
			likeFruit += " 입니다.";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<h3>");
		printWriter.println(name + "(" + "<font color = '"+ color + "'>"+ id + "</font>"+ ")");
		printWriter.println("<br>당신이 좋아하는 과일은 " + likeFruit);
		printWriter.println("</h3>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
