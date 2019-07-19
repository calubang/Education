<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.*, java.sql.*, java.net.URLEncoder"%>
<%!
public void init(){
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading 성공!!!");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<%
System.out.println("회원가입 하러 왔다.........");
request.setCharacterEncoding("utf-8");
Connection con = null;
PreparedStatement pstmt = null;
int result = 0;

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
%>
<% 
String root = request.getContextPath();
if(result != 0) { 
	response.sendRedirect(root+"/user/registerOK.jsp?name="+URLEncoder.encode(name, "utf-8"));
} else {
	response.sendRedirect(root+"/user/registerOK.jsp");
}
%>
