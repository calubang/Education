<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*, java.net.URLEncoder"%>
<%!
public void init() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading 성공!!!");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<%
//선언부
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
	int index = 0;
	pstmt.setString(++index, id);
	pstmt.setString(++index, pass);
	rs = pstmt.executeQuery();

	if (rs.next()) {
		name = rs.getString("name");
	}
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	if (pstmt != null) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if (con != null) {
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
if(name != null) {
	response.sendRedirect(root+"/user/loginOK.jsp?name="+URLEncoder.encode(name, "utf-8"));
} else {
	response.sendRedirect(root+"/user/loginFail.jsp");
}
%>