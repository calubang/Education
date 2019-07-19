package com.kitri.util;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class DBConnection {
	
	static {
		try {
			Class.forName(SiteConstance.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		DataSource ds = null;
		try {
			Context ictx = new InitialContext();
			Context ctx = (Context)ictx.lookup("java:comp/env");
			ds = (DataSource)ctx.lookup("jdbc/kitri");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return ds.getConnection();
	}
}
