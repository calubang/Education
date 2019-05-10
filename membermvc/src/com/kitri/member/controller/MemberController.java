package com.kitri.member.controller;

import javax.servlet.http.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.service.MemberServiceImpl;
import com.kitri.util.SiteConstance;

public class MemberController {
	
	private static MemberController memberController;
	
	static {
		memberController = new MemberController();
	}
	
	private MemberController() {}
		
	public static MemberController getMemberController() {
		return memberController;
	}

	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
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
		
		if(cnt != 0 ) {
			request.setAttribute("userInfo", dto);
			path = "/user/member/registerOK.jsp";
		} else {
			path = "/user/member/registerFail.jsp";
		}
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String path = SiteConstance.SITE_MAIN;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto dto = MemberServiceImpl.getMemberService().loginMember(id, pass);
		
		if(dto != null) {
			//cookie
			if("idsave".equals(request.getParameter("idsave"))) {
				Cookie cookie = new Cookie("kid_inf", id);
				cookie.setDomain("localhost");
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60*24*365*50);
				response.addCookie(cookie);	
			} else {
				Cookie cookies[] = request.getCookies();
				if(cookies != null){
					for(Cookie cookie : cookies){
						if("kid_inf".equals(cookie.getName())){
							cookie.setDomain("localhost");
							cookie.setPath(request.getContextPath());
							cookie.setMaxAge(0);
							response.addCookie(cookie);	
							break;
						}
					}
				}
			}
			//session
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", dto);
			path = "/user/login/loginOK.jsp";
		} else {
			path = "/user/login/loginFail.jsp";
		}
		
		return path;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		//해당 att 를 null 로 초기화
		//session.setAttribute("userInfo", null);
		
		//해당 attribute를 지울때
		//session.removeAttribute("userInfo");
		
		//session의 모든 정보를 지울때
		session.invalidate();
		return "/user/login/login.jsp";
	}
}
