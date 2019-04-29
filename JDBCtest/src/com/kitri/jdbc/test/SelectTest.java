package com.kitri.jdbc.test;

import java.io.*;
import java.sql.*;
import java.util.*;

public class SelectTest {
	
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Failed!!");
			e.printStackTrace();
		}
	}
	
	public Properties propertiesLoad() {
		
		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(new FileReader(new File("src\\com\\kitri\\jdbc\\test\\user.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public Connection makeConnection() throws SQLException {
		Connection con = null;
		Properties user = propertiesLoad();
		con = DriverManager.getConnection(user.getProperty("url"), user);
		System.out.println("Connection Success!!!");
		
		return con;
	}
	
	public List<MemberDto> memberList(String searchName) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = makeConnection();
			String sql = "";
			sql += "select no, name, id, joindate \n";
			sql += "from jdbctest \n";
			if(searchName != null) {
				sql += "where name = '" + searchName + "'";
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJoinDate(rs.getString("joindate"));
				
				list.add(memberDto);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return list;
	}
	
	private List<MemberDto> memberList(int no) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		List<MemberDto> list = new ArrayList<MemberDto>();
		try {
			con = makeConnection();
			stmt = con.createStatement();
			sql += "select \r\n" + 
					"	no\r\n" + 
					"	, name\r\n" + 
					"	, id\r\n" + 
					"	, case \r\n" + 
					"		when joindate >= to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') then\r\n" + 
					"			to_char(joindate, 'hh24:mm:ss')\r\n" + 
					"		else\r\n" + 
					"			to_char(joindate, 'yy-mm-dd')\r\n" + 
					"	end joindate\r\n" + 
					"from jdbctest\r\n";
			if(no != -1) {
				sql += "where no = " + no + " ";
			}
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJoinDate(rs.getString("joindate"));
				
				list.add(memberDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		
		return list;
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		String searchName = null;
		List<MemberDto> list = st.memberList(searchName);
		
		System.out.println("회원정보\t이름\t아이디\t가입일");
		System.out.println("-----------------------------");
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getNo() + "\t" + memberDto.getName() + "\t" + memberDto.getId() + "\t" + memberDto.getJoinDate());
		}
		
		int no = 201;
//		int no = -1;
		System.out.println("회원번호가 " + no + "인 회원 검색!!!");
		//이름 : 
		//id : 
		//가입일 : si:mi:ss(오늘)
		//가입일 : 19.04.25 (오늘 x)
		//10번 회원은 존재하지 않습니다.
		
		list = st.memberList(no);
		if(list.size() == 0) {
			System.out.println(no + "번 회원은 존재하지 않습니다.");
		}else {
			for(MemberDto memberDto : list) {
				System.out.println("이름 : " +memberDto.getName());
				System.out.println("id : " +memberDto.getId());
				System.out.println("가입일 : " +memberDto.getJoinDate());
			}
		}
	}

}
