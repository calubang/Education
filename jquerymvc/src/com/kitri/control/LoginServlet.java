package com.kitri.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.service.CustomerService;
import com.kitri.util.MoveUrl;
import com.kitri.util.SiteConstance;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println(act);
		String path = SiteConstance.SITE_MAIN;
		String result = "";
		
		if("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			System.out.println(id + "//" + pass);
			result = CustomerService.login(id, pass);
			
			request.setAttribute("loginResult", result);
			path = "/loginResult.jsp";
			
			MoveUrl.forword(request, response, path);
		}else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
