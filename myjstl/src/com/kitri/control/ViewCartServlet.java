package com.kitri.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;
import com.kitri.service.ProductService;
import com.kitri.util.MoveUrl;

@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	
	public ViewCartServlet() {
		service = new ProductService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 장바구니 가져오기
		//세션속성중 "cart" 속성얻기
		//map 이 반환
		//null 인지 아닌지 확인해서 보여주기 <- 장바구니에 담지도 않고 보는경우
		
		//null 이 아니라면....
		//for문으로 전체 검색해서
		//상품에 대한 정보를 실시간으로 받아온다
		//보안상의 문제도 있음. 누군가가 상품가격을 바꾼채로 서버에 데이터를 요청시켜버린다면?? 여러가지로 문제가된다
		//db에서 받아온 product를 다시 session의 cart 에 담아준다.
		//안드로이드 확인용 코드
		String userAgent = request.getHeader("User-Agent");
		//System.out.println(userAgent);
		
		
		HttpSession session = request.getSession();
		String path = "index.jsp";
		
		Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
		Map<Product, Integer> dataCart = new HashMap<Product, Integer>(); 
		if(cart != null) {
			for(Product cartProduct : cart.keySet()) {
				Product dataProduct = service.findByNo(cartProduct.getProd_no());
				//System.out.println(product);
				int quantity = cart.get(cartProduct);
				dataCart.put(dataProduct, quantity);
			}
			request.setAttribute("dataCart", dataCart);
		}else {
			//카트가 아직 없으면?
		}
		path = "viewcartresult.jsp";
		//안드로이드 응답페이지
		if(userAgent.contains("Android")) {
			path = "viewcartresultjson.jsp";
		}
		
		MoveUrl.forword(request, response, path);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
