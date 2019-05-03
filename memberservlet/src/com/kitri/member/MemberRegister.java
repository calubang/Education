package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class MemberRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading 성공!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//선언부
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		
		System.out.println("회원가입 하러 왔다.........");
		request.setCharacterEncoding("utf-8");
		
		//1. 데이터 받기
		//	name, id, pass, passcheck, 이메일1, 이메일2, 전번 123, 우편번호, 주소, 상세주소
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String emailid = request.getParameter("emailid");
		String emaildomain = request.getParameter("emaildomain");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String addressdetail = request.getParameter("address_detail");
		
		System.out.println("name = " + name + "\nid = " + id + "\npass = " + pass + "\nemail = " + emailid + "\nemaildomain = " + emaildomain
				+ "\ntel = " + tel1 + "-" + tel2 + "-" + tel3 + "\nzipcode = " + zipcode + "\naddress = " + address + "\naddress_detail = "+ addressdetail);
		
		//2. 로직처리
//		1의 데이터를 db에 insert
		/**
		 insert all     
	into member(    
	id    
	, name    
	, pass    
	, emailid    
	, emaildomain    
	, joindate    
	) values (    
		?    
		, ?    
		, ?    
		, ?    
		, ?    
		, sysdate    
	)    
	into member_detail(    
		id    
		, zipcode    
		, address    
		, address_detail    
		, tel1    
		, tel2    
		, tel3    
	) values (    
		?    
		, ?    
		, ?    
		, ?    
		, ?    
		, ?    
		, ?    
	)    
select * from dual
		 */
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("insert all     \n");
			sql.append("	into member(    \n");
			sql.append("	id    \n");
			sql.append("	, name    \n");
			sql.append("	, pass    \n");
			sql.append("	, emailid    \n");
			sql.append("	, emaildomain    \n");
			sql.append("	, joindate    \n");
			sql.append("	) values (    \n");
			sql.append("		?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, sysdate    \n");
			sql.append("	)    \n");
			sql.append("	into member_detail(    \n");
			sql.append("		id    \n");
			sql.append("		, zipcode    \n");
			sql.append("		, address    \n");
			sql.append("		, address_detail    \n");
			sql.append("		, tel1    \n");
			sql.append("		, tel2    \n");
			sql.append("		, tel3    \n");
			sql.append("	) values (    \n");
			sql.append("		?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("	)    \n");
			sql.append("select * from dual\n");
			
			
			pstmt = con.prepareStatement(sql.toString());
			int index=0;
			pstmt.setString(++index, id);
			pstmt.setString(++index, name);
			pstmt.setString(++index, pass);
			pstmt.setString(++index, emailid);
			pstmt.setString(++index, emaildomain);
			pstmt.setString(++index, id);
			pstmt.setString(++index, zipcode);
			pstmt.setString(++index, address);
			pstmt.setString(++index, addressdetail);
			pstmt.setString(++index, tel1);
			pstmt.setString(++index, tel2);
			pstmt.setString(++index, tel3);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//3. response page 작성
		//	!0 : 이름님 회원가입을 환영합니다.
		// 	0 : 서버 문제로 회원가입이 실패하였습니다. 다음에 다시 시도하세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		if(result != 0) {
			out.println(name + " 님 회원가입을 환영합니다.");
			out.println("로그인 후 모든 서비스를 이용할 수 있습니다.<br>");
			out.println("<a href='/memberservlet/user/login.html'>로그인</a>");			
		} else {
			out.println("<font size='15' color='red'>");
			out.println("서버 문제로 회원가입이 실패하였습니다.");
			out.println("다음에 다시 시도하세요.");
			out.println("</font>");
		}
		
		out.println("	</body>");
		out.println("</html>");
	}

}
