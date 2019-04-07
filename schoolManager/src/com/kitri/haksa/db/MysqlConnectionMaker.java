package com.kitri.haksa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectionMaker implements ConnectionMaker{
	
	@Override
	public Connection makeConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(
					"jdbc:mysql://Localhost/springbook", "spring", "bool");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
