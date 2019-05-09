package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.*;
import com.kitri.member.service.MemberService;
import com.kitri.member.service.MemberServiceImpl;
import com.kitri.util.SiteConstance;

@WebServlet({ "/MemberController", "/user" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(act == null) {
			//에러코드 삽입
			return;
		}
		
		System.out.println(act);
		//분기
		switch (act) {
		case "join":
			response.sendRedirect("/membermvc/user/member/member.jsp");
			break;
			
		case "login":
			response.sendRedirect("/membermvc/user/login/login.jsp");
			break;
			
		case "idcheck":
			String sid = request.getParameter("sid");
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);
			out.print(resultXML);
			break;
		case "zipsearch":
			String doro = request.getParameter("doro");
			String doroXML = MemberServiceImpl.getMemberService().zipSearch(doro);
			//System.out.println(doroXML);
			out.print(doroXML);
			break;
		case "register":
			
			MemberDetailDto dto = new MemberDetailDto();
			dto.setName(request.getParameter("name"));
			dto.setId(request.getParameter("id"));
			dto.setPass(request.getParameter("pass"));
			dto.setEmailid(request.getParameter("emailid"));
			dto.setEmaildomain(request.getParameter("emaildomain"));
			dto.setTel1(request.getParameter("tel1"));
			dto.setTel2(request.getParameter("tel2"));
			dto.setTel3(request.getParameter("tel3"));
			dto.setZipcode(request.getParameter("zipcode"));
			dto.setAddress(request.getParameter("address"));
			dto.setAddressDetail(request.getParameter("address_detail"));

			int cnt = MemberServiceImpl.getMemberService().registerMember(dto);
			System.out.println("cnt = " + cnt);
			break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}
