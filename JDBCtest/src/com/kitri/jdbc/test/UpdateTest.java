package com.kitri.jdbc.test;

import java.sql.*;

public class UpdateTest {
	
	public UpdateTest(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading Success!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println(con + "DB Connection!!!");
		return con;
	}
	
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		Connection con = null;
		Statement stmt = null;
		StringBuffer sql = new StringBuffer();
		int cnt = 0;
		String name = "안병욱";
		sql.append("update jdbctest\r\n"); 
		sql.append("set\r\n"); 
		sql.append("	joindate = sysdate\r\n");
		sql.append("where name = '" + name  + "'");
		
		System.out.println(sql);
		try {
			con = ut.makeConnection();
			stmt = con.createStatement();
			
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
		
		System.out.println(cnt);
		if(cnt > 0) {
			System.out.println("update Success!!!");
		}else {
			System.out.println("update Failed!!!");
		}
		
	}

}
