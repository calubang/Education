package com.kitri.basic;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbcounter")
public class DBCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String IMG_PATH = "/basicservlet/img/";
    private static Properties DB = null;

    @Override
    public void init() throws ServletException {
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Load 성공!!");
			DB = propertiesLoad();

    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    public Properties propertiesLoad() {
    	Properties properties = new Properties();
    	
    	try {
			properties.load(new FileReader(new File(this.getClass().getResource("\\user.properties").toURI())));
    		//properties.load(new FileReader(new File("..\\basicservlet\\src\\com\\kitri\\basic\\user.properties")));
			System.out.println("Properties Load 성공!!");
    		return properties;
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	catch (URISyntaxException e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    public Connection makeConnection() throws SQLException {
    	Connection con = null;
    	
    	if(DB == null) {
    		return null;
    	}
    	
    	con = DriverManager.getConnection(DB.getProperty("url"), DB);
    	System.out.println("DB Connection 성공!!");
    	
    	return con;
    }
    
    public int selectCounter() {
    	Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = 
				"select no\r\n" + 
				"from counter";
		
		try {
			con = makeConnection();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt("no");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(con, stmt);
		}
		return -1;
    }
    
    public int updateCounter() {
    	Connection con = null;
		Statement stmt = null;
		String sql = 
				"update counter\r\n" + 
				"set no = no + 1" ;
		int result = 0;
		
		try {
			con = makeConnection();
			
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(con, stmt);
		}
		return result;
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		updateCounter();
		int counter = selectCounter();
		
		String counterStr = String.format("%08d", counter);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은 ");
		
		for(int i =0 ; i<counterStr.length(); i++) {
			out.print("<img src='"+IMG_PATH+counterStr.charAt(i)+".png' width='50px' height='50'>");
		}
		
		out.println(counter);
		out.println("번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}

	private void closeDB(Connection con, Statement stmt) {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
