package com.kitri.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;
import com.kitri.service.ProductService;
import com.kitri.util.MoveUrl;

@WebServlet("/productlist")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService service;
	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	service = new ProductService();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("product 받으러 왔다.");
		String act = request.getParameter("act");
		List<Product> list = null;
		
		String path = "index.jsp";
		if(act == null) {
			return;
		}
		
		
		switch (act) {
		case "productAll":
			list = service.findAll();
			request.setAttribute("productList", list);
			path = "/productlistresult.jsp";
			MoveUrl.forword(request, response, path);
			break;
		case "productAllJSON":
			list = service.findAll();
			//request.setAttribute("productList", list);
			ObjectMapper mapper = new ObjectMapper();
			request.setAttribute("productListJSON", mapper.writeValueAsString(list));
			path = "/productlistresultJSON.jsp";
			MoveUrl.forword(request, response, path);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
