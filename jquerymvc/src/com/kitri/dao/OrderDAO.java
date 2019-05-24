package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class OrderDAO {
	
	public void insert(OrderInfo info) throws AddException {
		Connection con = null;
		try {
			con = DBConnection.makeConnection();
			con.setAutoCommit(false);
			insertInfo(con, info);
			
			List<OrderLine> lines = info.getLines();
			insertLine(con, lines);
			con.commit();
		} catch (Exception e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			//e.printStackTrace();
			throw new AddException("주문추가 오류"+e.getMessage());
		} finally {
			DBClose.close(con, null);
		}

	}
	public void insertInfo(Connection con, OrderInfo info) throws SQLException {
		PreparedStatement pstmt = null;	
		int result = 0;
		StringBuffer insertInfo = new StringBuffer();
		insertInfo.append("insert into order_info(	\n");
		insertInfo.append("     order_no	\n");
		insertInfo.append("    , order_id	\n");
		insertInfo.append(") values(	\n");
		insertInfo.append("    ORDER_INFO_NO_SEQ.nextval	\n");
		insertInfo.append("    , ?	\n");
		insertInfo.append(" )\n");
		
		try {
			pstmt = con.prepareStatement(insertInfo.toString());
			pstmt.setString(1, info.getCustomer().getId());
			result = pstmt.executeUpdate();
			
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void insertLine(Connection con, List<OrderLine> lines) throws SQLException {
		PreparedStatement pstmt = null;	
		StringBuffer insertLineSQL = new StringBuffer();
		insertLineSQL.append("insert into order_line(\n");
		insertLineSQL.append("    order_no\n");
		insertLineSQL.append("    , order_prod_no\n");
		insertLineSQL.append("    , order_quantity\n");
		insertLineSQL.append(") values(\n");
		insertLineSQL.append("    ORDER_INFO_NO_SEQ.currval\n");
		insertLineSQL.append("    , ? \n");
		insertLineSQL.append("    , ? \n");
		insertLineSQL.append(")\n");
		
		try {
			pstmt = con.prepareStatement(insertLineSQL.toString());
			int index = 0;
			for(OrderLine line : lines) {
				index = 0;
				pstmt.setString(++index, line.getProduct().getProd_no());
				pstmt.setInt(++index, line.getOrder_quantity());	
				//pstmt.executeUpdate();
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<OrderInfo> selectByCustomerId(String id) {
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer selectByCustomerIdSQL = new StringBuffer();
		selectByCustomerIdSQL.append("select \n");
		selectByCustomerIdSQL.append("    info.order_no\n");
		selectByCustomerIdSQL.append("    , info.order_dt\n");
		selectByCustomerIdSQL.append("    , prod.prod_no\n");
		selectByCustomerIdSQL.append("    , prod.prod_name\n");
		selectByCustomerIdSQL.append("    , prod.prod_price\n");
		selectByCustomerIdSQL.append("    , line.order_quantity\n");
		selectByCustomerIdSQL.append("from \n");
		selectByCustomerIdSQL.append("    order_info info\n");
		selectByCustomerIdSQL.append("    join order_line line\n");
		selectByCustomerIdSQL.append("        on info.order_no = line.order_no\n");
		selectByCustomerIdSQL.append("    join product prod \n");
		selectByCustomerIdSQL.append("        on prod.prod_no = line.order_prod_no\n");
		selectByCustomerIdSQL.append("where \n");
		selectByCustomerIdSQL.append("    info.order_id = ? \n");
		selectByCustomerIdSQL.append("order by \n");
		selectByCustomerIdSQL.append("    order_no desc\n");
		selectByCustomerIdSQL.append("    , prod_no\n");
		
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(selectByCustomerIdSQL.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			OrderInfo info = null;
			OrderLine line = null;
			List<OrderLine> lines = null;
			int oldOrder_no = -1;
			while(rs.next()) {
				//비교하기 위한 order_no
				int order_no = rs.getInt("order_no");
				//기존과 다르다면..
				if(oldOrder_no != order_no) {
					//orderInfo , lines 재생성하여 list에 넣어둠
					info = new OrderInfo();
					list.add(info);
					info.setOrder_no(order_no);
					info.setOrder_dt(rs.getDate("order_dt"));
					lines = new ArrayList<OrderLine>();
					info.setLines(lines);
					oldOrder_no = order_no;
				}
				//이부분부터 while이 돌때마다 항상 재생성 해야할 부분
				line = new OrderLine();
				Product product = new Product();
				product.setProd_no(rs.getString("prod_no"));
				product.setProd_name(rs.getString("prod_name"));
				product.setProd_price(rs.getInt("prod_price"));
				
				line.setProduct(product);
				line.setOrder_quantity(rs.getInt("order_quantity"));
				//완성된 line을 lines에 넣어둔다.
				lines.add(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return list;
	}
	
}
