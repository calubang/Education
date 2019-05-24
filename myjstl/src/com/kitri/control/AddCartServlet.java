package com.kitri.control;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.websocket.Session;

import com.kitri.dto.Product;
import com.kitri.util.MoveUrl;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public AddCartServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("addcartservlet 들어옴");
		// 장바구니는 map 구조로 만든다
		// key : 상품코드(String) / value : 수량  -> key 가 String이 되어버리면 equals method를 따로 관리할 수 없기에 좋은 방법은 아니다
		// key : Product / value : 수량 -> key를 
		
		String prodNo = request.getParameter("prodno");
		String quantityStr = request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityStr);
		
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
		if(cart == null) {
			//session에 catr 가 없을 때에만 수행
			cart = new HashMap<Product, Integer>();
			session.setAttribute("cart", cart);
		}
		Product product = new Product();
		product.setProd_no(prodNo);
		
		//System.out.println("제품번호 : " + prodNo + " // 수량 : " + quantity);
		//장바구니에 해당상품이 존재하는지 확인
		Integer checkNo = cart.get(product);
		if(checkNo != null) {
			quantity += checkNo;
		}
		
		cart.put(product, quantity);
		
		/*
		 * System.out.println("--- 장바구니 내용 ---"); Set<Product> keys = cart.keySet();
		 * for(Product key : keys) { System.out.println("상품번호 : " + key.getProd_no() +
		 * ",   수량 : " + cart.get(key)); }
		 */
		
		MoveUrl.forword(request, response, "/addcart.jsp");
		
		//질문할거 : 서블릿을 계속 만드는게 나은가?
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
