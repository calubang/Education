package com.kitri.guestbook.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

import com.kitri.guestbook.dto.GuestaBookDto;

public class GuestBookDao {
	private static Properties DB = null;
	
	public GuestBookDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Load 성공!!");
			DB = propertiesLoad();

    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Properties propertiesLoad() {
		Properties properties = new Properties();
    	
    	try {
			properties.load(new FileReader(new File(this.getClass().getResource("\\user.properties").toURI())));
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
	
	private void closeDB(Connection con, Statement stmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
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
	
	public int insert(GuestaBookDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into guestbook(	\n");
		sql.append("	seq							\n");
		sql.append("	, name						\n");
		sql.append("	, subject						\n");
		sql.append("	, content					\n");
		sql.append("	, logtime					\n");
		sql.append(") values(						\n");
		sql.append("	guestbook_seq.nextval	\n");
		sql.append("	, ?								\n");
		sql.append("	, ?								\n");
		sql.append("	, ?								\n");
		sql.append("	, sysdate					\n");
		sql.append(")									\n");
		
		try {
			con = makeConnection();
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getSubject());
			pstmt.setString(++index, dto.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
