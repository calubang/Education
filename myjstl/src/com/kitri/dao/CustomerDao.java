package com.kitri.dao;

import java.sql.*;
import java.util.List;

import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class CustomerDao {
	
	public Customer selectById(String id) throws NotFoundException {
		//DB연결
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		
		try {
			con = DBConnection.makeConnection();
			String selectByIdSQL = 
					"SELECT 			\n"
					+ "	id 				\n"
					+ "	, pass		\n"
					+ "	, name		\n"
					+ "	, address	\n"
					+ "from				\n"
					+ "	customer	\n"
					+ "where			\n"
					+ "	id = ?";

			pstmt = con.prepareStatement(selectByIdSQL);
			int index = 0;
			pstmt.setString(++index, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setPass(rs.getString("pass"));
				customer.setName(rs.getString("name"));
			} else {
				//id 를 찾지 못할 때
				throw new NotFoundException("아이디에 해당하는 고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotFoundException("아이디에 해당하는 고객이 없습니다.");
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return customer;
	}
	
	public List<Customer> selectByName(String name){
		return null;
	}
	
	public List<Customer> selectAll(){
		
		return null;
	}
	
	public int insert(Customer customer) {
		return 0;
	}
	
}
