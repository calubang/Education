package com.kitri.haksa.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.haksa.data.HaksaDto;

public class HaksaDao {

	private ConnectionMaker connectionMaker;
	
	public HaksaDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public List<HaksaDto> getAll() {
		List<HaksaDto> list = new ArrayList<HaksaDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select age";
		sql += ", name";
		sql += ", key";
		sql += ", value";
		sql += "	from school";
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				HaksaDto haksa = new HaksaDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(haksa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int add(HaksaDto haksa) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//String sql;
		String sql = "insert into school(" + 
				"    name" + 
				"    , age" + 
				"    , key" + 
				"    , value" + 
				") VALUES(" + 
				"    ?" + 
				"    , ?" + 
				"    , ?" + 
				"    , ?" + 
				")"; 
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, haksa.getName());
			ps.setInt(2, haksa.getAge());
			ps.setInt(3, haksa.getKey());
			ps.setString(4, haksa.getValue());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public List<HaksaDto> findName(String name) {
		List<HaksaDto> list = new ArrayList<HaksaDto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select name\r\n" + 
				"       , age\r\n" + 
				"       , key\r\n" + 
				"       , value\r\n" + 
				"       \r\n" + 
				"from school\r\n" + 
				"where\r\n" + 
				"    name = ?";
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				HaksaDto haksa = new HaksaDto(rs.getInt(2), rs.getString(1), rs.getInt(3), rs.getString(4));
				list.add(haksa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int delete(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete school\r\n" + 
				"where name = ?"; 
		try {
			con = connectionMaker.makeConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
}
