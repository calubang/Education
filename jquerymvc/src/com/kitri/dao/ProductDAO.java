package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.Product;
import com.kitri.dto.ProductCategory;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class ProductDAO {
	public List<Product> selectAll(){
		List<Product> list = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		StringBuffer productSelectAll = new StringBuffer();
		productSelectAll.append("select \n");
		productSelectAll.append("    cate.cate_no\n");
		productSelectAll.append("    , cate.cate_name\n");
		productSelectAll.append("    , prod.prod_no\n");
		productSelectAll.append("    , prod.prod_name\n");
		productSelectAll.append("    , prod.prod_price\n");
		productSelectAll.append("    , prod.prod_detail\n");
		productSelectAll.append("from \n");
		productSelectAll.append("    product prod \n");
		productSelectAll.append("    inner join product_category cate\n");
		productSelectAll.append("			on prod.prod_cate = cate.cate_no\n");
		productSelectAll.append("order by \n");
		productSelectAll.append("    cate_no\n");
		productSelectAll.append("    , prod_name\n");

		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(productSelectAll.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				ProductCategory productCategory = new ProductCategory();
				
				//상품
				product.setProd_no(rs.getString("prod_no").trim());
				product.setProd_name(rs.getString("prod_name"));
				product.setProd_price(rs.getInt("prod_price"));
				product.setProd_detail(rs.getString("prod_detail"));
				
				//상품카테고리
				productCategory = new ProductCategory();
				productCategory.setCate_no(rs.getString("cate_no"));
				productCategory.setCate_name(rs.getString("cate_name"));
					
				product.setProductCategory(productCategory);
				
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return list;
	}

	public Product selectByNo(String prodNo) {
		Product product = null;
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		StringBuffer selectById = new StringBuffer();
		selectById.append("select\n");
		selectById.append("    prod.prod_no\n");
		selectById.append("    , prod.prod_cate\n");
		selectById.append("    , prod.prod_name\n");
		selectById.append("    , prod.prod_price\n");
		selectById.append("    , prod.prod_detail\n");
		selectById.append("    , cate.cate_no\n");
		selectById.append("    , cate.cate_name\n");
		selectById.append("from\n");
		selectById.append("    product prod\n");
		selectById.append("    inner join product_category cate\n");
		selectById.append("        on prod.prod_cate = cate.cate_no\n");
		selectById.append("where \n");
		selectById.append("    prod_no = ? \n");

		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(selectById.toString());
			pstmt.setString(1, prodNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				ProductCategory productCategory = new ProductCategory();
				//상품
				product.setProd_no(rs.getString("prod_no").trim());
				product.setProd_name(rs.getString("prod_name"));
				product.setProd_price(rs.getInt("prod_price"));
				product.setProd_detail(rs.getString("prod_detail"));
				//상품카테고리
				productCategory = new ProductCategory();
				productCategory.setCate_no(rs.getString("cate_no"));
				productCategory.setCate_name(rs.getString("cate_name"));
					
				product.setProductCategory(productCategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return product;
	}
	
}
