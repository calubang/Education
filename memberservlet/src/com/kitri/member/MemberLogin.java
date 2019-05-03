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

@WebServlet("/login")
public class MemberLogin extends HttpServlet {
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
		System.out.println("로그인 하러 왔다......");
		request.setCharacterEncoding("utf-8");
		//선언부
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		
		//1. 데이터 받기
		// id, pass
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//2. 데이터 로직
		// DB 에서 select 
		/* select
		  		id
		  		, name
		  		, pass
		  		, emailid
		  		, emaildomain
			from member
			where 
				id = ?
				and pass = ?
			
			
			select 
				member.id
				, member.name
				, member.pass
				, member.emailid
				, member.emaildomain
				, member_detail.zipcode
				, member_detail.address
				, member_detail.address_detail
				, member_detail.tel1
				, member_detail.tel2
				, member_detail.tel3
			from
				member
				, member_detail
			where 
				member.id = member_detail.id(+)
		*/
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("select	\n");
			sql.append("	id	\n");
			sql.append("	, name	\n");
			sql.append("	, pass	\n");
			sql.append("	, emailid	\n");
			sql.append("	, emaildomain	\n");
			sql.append("from member	\n");
			sql.append("where 	\n");
			sql.append("	id = ?	\n");
			sql.append("	and pass = ?	\n");
			
			pstmt = con.prepareStatement(sql.toString());
			int index=0;
			pstmt.setString(++index, id);
			pstmt.setString(++index, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			
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
		
		
		//3. response 구성하기
		// name != null 이 나오면 정상 로그인 -> xxx 님, 환영합니다. 
		// name == null 이 나오면 
		// 아이디 또는 비밀번호를 다시 확인하세요.
		// 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		if(name != null) {
			out.println("<font size='15' color='green'>");
			out.println(name + " 님, 환영합니다.");			
			out.println("</font>");
		} else {
			out.println("<font size='10' color='red'>");
			out.println("아이디 또는 비밀번호를 다시 확인하세요.<br>");			
			out.println("등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.<br>");	
			out.println("<a href='/memberservlet/user/login.html'>로그인<br></a>");	
			out.println("</font>");
		}
		
		out.println("	</body>");
		out.println("</html>");
	}

}
