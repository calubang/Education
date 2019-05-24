package com.kitri.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.OrderInfo;
import com.kitri.service.OrderService;
import com.kitri.util.MoveUrl;

@WebServlet("/vieworder")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService service;   
    public ViewOrderServlet() {
    	service = new OrderService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 추출
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("loginInfo");
		List<OrderInfo> orderList = service.findByCustomerId(id);
		
		//응답페이지에 보내기
		request.setAttribute("orderlist", orderList);
		String path = "/order/vieworderresult.jsp";
		MoveUrl.forword(request, response, path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
