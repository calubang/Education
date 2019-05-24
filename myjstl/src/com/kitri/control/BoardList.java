package com.kitri.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dao.PageBean;
import com.kitri.dto.RepBoard;
import com.kitri.service.RepBoardService;
import com.kitri.util.MoveUrl;

@WebServlet("/boardlist")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RepBoardService service;
	private static final int POST_NUMBER_PER_PAGE = 10;
	private static final int PAGE_GROUP_NUMBER = 3;
    public BoardList() {
        super();
        service = new RepBoardService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentpage");
		int currentPage = 1;
		if(currentPageStr != null) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
		int totalRow = service.calculateTotalPage();
		String url = "boardlist";
		PageBean<RepBoard> pageBean = new PageBean<RepBoard>(
				POST_NUMBER_PER_PAGE
				, PAGE_GROUP_NUMBER
				, currentPage
				, totalRow
				, url);
		pageBean.setList(service.findByRows(pageBean.getStartRow(), pageBean.getEndRow()));
		request.setAttribute("pageBean", pageBean);
		
		//현재 입력받은 페이지당 뿌려줄 글번호
		//int startRow = (currentPage-1)*POST_NUMBER_PER_PAGE + 1;
		//int endRow = currentPage*POST_NUMBER_PER_PAGE;
		//총페이지수 계산
		//페이지 그룹에 보여줄 페이지 수
		//총 게시글 수를 반환
		
		//int maxPage = (int)Math.ceil((double)totalCnt/POST_NUMBER_PER_PAGE);
		//System.out.println("totalCnt : " +totalCnt + " // maxPage : " + maxPage);
		//request.setAttribute("maxPage", maxPage);
		
		//페이지 그룹에서의 시작과 끝을 계산
		//int startPage = ((currentPage-1)/PAGE_GROUP_NUMBER)*PAGE_GROUP_NUMBER + 1;
		//int endPage = ((currentPage-1)/PAGE_GROUP_NUMBER + 1) * PAGE_GROUP_NUMBER;
		//endPage = endPage > maxPage ? maxPage : endPage;
		
		/*
		 * currentPage = 1; maxPage = 20; for(currentPage = 1 ; currentPage <= maxPage ;
		 * currentPage++) { startPage =
		 * ((currentPage-1)/PAGE_GROUP_NUMBER)*PAGE_GROUP_NUMBER + 1; endPage =
		 * ((currentPage-1)/PAGE_GROUP_NUMBER + 1) * PAGE_GROUP_NUMBER; endPage =
		 * endPage > maxPage ? maxPage : endPage;
		 * System.out.println("------------------------------------");
		 * System.out.println("이전 페이지 : " + startPage); System.out.println("현재 페이지 : " +
		 * currentPage); System.out.println("마지막 페이지 : " + endPage);
		 * System.out.println("------------------------------------"); }
		 */
		
		String path = "/repboard/boardlistresult.jsp";
		MoveUrl.forword(request, response, path);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
