package com.kitri.jdbc.test;

import java.sql.*;

public class InsertTest {
	
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading Success!!!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection con = null;
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connection Success!!!");

		return con;
	}
	
	public static void main(String[] args) {
		String name = "안병욱";
		String id = "abo";
		
		InsertTest it = new InsertTest();
		Connection con = null;
		Statement stmt = null;
		int cnt = 0;
		
		try {
			con = it.makeConnection();
			stmt = con.createStatement();
			String sql = 
					"insert into jdbctest (\r\n" + 
					"	no\r\n" + 
					"	, name\r\n" + 
					"	, id\r\n" + 
					"	, joindate\r\n" + 
					") values (\r\n" + 
					"	jdbctest_no_seq.nextval\r\n" + 
					"	, '" + name + "'\r\n" + 
					"	, '" + id + "'\r\n" + 
					"	, sysdate\r\n" + 
					")";
			
			cnt = stmt.executeUpdate(sql);
			
			
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
		
		if(cnt != 0) {
			System.out.println("Insert Success!!!!!!!");
		}else {
			System.out.println("Insert failed!!!!!!!");
		}
		
	}

}
