package com.kitri.jdbc.test;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DeleteTest {
	
	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading Success!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Properties propertiesLoad() {
		Properties user = new Properties();
		
		try {
			user.load(new FileReader(new File("src\\com\\kitri\\jdbc\\test\\user.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public Connection makeConnection() throws SQLException {
		Connection con = null;
		
		Properties user = propertiesLoad();
		String url = user.getProperty("url");
		con = DriverManager.getConnection(url, user);
		System.out.println("Connection Success!! [ " + con + "]");
		return con;
	}
	
	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		Connection con = null;
		Statement stmt = null;
		String name = "안병욱";
		StringBuffer sql = new StringBuffer();
		sql.append("delete from jdbctest\n");
		sql.append("where name = '" + name + "'");
		
		int cnt = 0;
		
		try {
			con = dt.makeConnection();
			stmt = con.createStatement();
			
			System.out.println(sql + "[실행]");
			cnt = stmt.executeUpdate(sql.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(cnt > 0) {
			System.out.println(cnt + "개 삭제되었습니다.");
		} else {
			System.out.println(cnt + "삭제 실패하였습니다.");
		}
	}
}
