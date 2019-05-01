package com.kitri.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int cnt = 0;
	private static final int max = 8;
	
	private String src = "/basicservlet/img/";
	
	//init()
	//디비 드라이버 로딩
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 성공!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Properties propertiesLoad() {
		Properties prop = new Properties();
		try {
			System.out.println(this.getClass().getResource("\\user.properties"));
			prop.load(new FileReader(new File(this.getClass().getResource("\\user.properties").toURI())));
			return prop;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Connection makeConnection() throws SQLException {
		Connection con = null;
		Properties db = propertiesLoad();
		
		//System.out.println(db);
		
		//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
		con = DriverManager.getConnection(db.getProperty("url"), db);
		System.out.println("Connection 성공!!");
		return con;
	}
	
	public void closeDB(Connection con, Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
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
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		Connection con = null;
		Statement stmt = null;
		String sql = 
				"update connectionlog\n" + 
				"set no = "+ cnt;
		System.out.println(sql);
		int result = 0;
		
		try {
			con = makeConnection();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(con, stmt);
		}
		
		if(result != 1) {
			System.out.println("DB Error!!!");
			return;
		}
		
		String count = String.format(("%0"+ max+ "d") , cnt);	
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은 ");
		
		for(int i = 0 ; i<count.length() ; i++) {
			out.print("<img src='"+ src + count.charAt(i) + ".png" +  "' width='50' height='50'>");
		}
		
		out.println(count);
		out.println("번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
