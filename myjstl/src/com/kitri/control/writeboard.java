package com.kitri.control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.service.RepBoardService;
import com.kitri.util.MoveUrl;

@WebServlet("/writeboard")
public class writeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RepBoardService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new RepBoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_subject = request.getParameter("subject");
		String board_writer = request.getParameter("writer");
		String board_password = request.getParameter("password");
		String board_contents = request.getParameter("contents");
		int result = -1;
		
		RepBoard repBoard = new RepBoard();
		repBoard.setParent_seq(0);
		repBoard.setBoard_subject(board_subject);
		repBoard.setBoard_writer(board_writer);
		repBoard.setBoard_password(board_password);
		repBoard.setBoard_contents(board_contents);
		
		try {
			service.write(repBoard);
			result = 1;
		} catch (AddException e) {
			e.printStackTrace();
			result = -1;
		}
		request.setAttribute("result", result);
		MoveUrl.forword(request, response, "/repboard/writeresult.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
