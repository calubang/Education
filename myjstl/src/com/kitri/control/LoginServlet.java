package com.kitri.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
		
		if("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			System.out.println(id + "//" + pass);
			int result = CustomerService.login(id, pass);
			HttpSession session = request.getSession();
			session.removeAttribute("loginInfo");
			if(result == 1) {
				session.setAttribute("loginInfo", id);
			}
			
			request.setAttribute("loginResult", result);
			path = "/loginResult.jsp";
			
			MoveUrl.forword(request, response, path);
		}else if("logout".equals(act)){
			HttpSession session = request.getSession();
			session.removeAttribute("loginInfo");
			MoveUrl.forword(request, response, "login/logoutResult.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
