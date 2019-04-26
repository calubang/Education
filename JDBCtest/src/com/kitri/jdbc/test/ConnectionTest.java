package com.kitri.jdbc.test;

import java.sql.*;

public class ConnectionTest {
	
	public ConnectionTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading Success!!!!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void dbConnect() {
		Connection con = null;
		try {
			//network어쩌구 : ip, port 혹은 앞에 형식이 틀렸을때
			//sid 어쩌구 : 서비스상에 orcl 이 안떠있을때
			//login 어쩌구 : id pass 가 틀렸을 때
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("DB Connection!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.dbConnect();
	}

	
}
