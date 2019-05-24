package com.kitri.control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;
import com.kitri.util.MoveUrl;

@WebServlet("/productInfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new ProductService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prodNo = request.getParameter("prodNo");
		//System.out.println("prodNo : " + prodNo);
		
		Product product = service.findByNo(prodNo);
		request.setAttribute("product", product);
		
		//System.out.println(product);
		String path = "productinforesult.jsp";
		MoveUrl.forword(request, response, path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
