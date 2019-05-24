package com.kitri.control;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.service.OrderService;
import com.kitri.util.MoveUrl;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService service;   
    public AddOrderServlet() {
        service = new OrderService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니 정보가 주문테이블에 저장
		OrderInfo info = new OrderInfo();
		Customer customer = new Customer();
		HttpSession session = request.getSession();
		//주문자 id설정
		customer.setId((String)session.getAttribute("loginInfo"));
		info.setCustomer(customer);
		
		//주문정보를 장바구니에서 불러오기
		Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
		List<OrderLine> lines = new ArrayList<OrderLine>();
		for(Product product : cart.keySet()) {
			OrderLine line = new OrderLine();
			line.setProduct(product);
			line.setOrder_quantity(cart.get(product));
			
			lines.add(line);
		}
		info.setLines(lines);
		
		String result = "-1";
		try {
			service.addOrder(info);
			session.removeAttribute("cart"); //장바구니 비우기
			result = "1";
		} catch (AddException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		request.setAttribute("result", result);
		MoveUrl.forword(request, response, "/addorderresult.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
