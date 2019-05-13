package com.kitri.admin.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class AdminDaoImpl implements AdminDao{

	private static AdminDao adminDao;
	
	static {
		adminDao = new AdminDaoImpl();
	}
	
	private AdminDaoImpl() {}
		
	public static AdminDao getAdminDao() {
		return adminDao;
	}

	@Override
	public List<MemberDetailDto> getMemberList(Map<String, String> map) {
		List<MemberDetailDto> list = new ArrayList<MemberDetailDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select	\n");
			sql.append("	member.id	\n");
			sql.append("	, member.name	\n");
			sql.append("	, member.emailid	\n");
			sql.append("	, member.emaildomain	\n");
			sql.append("	, member.joindate	\n");
			sql.append("	, member_detail.tel1	\n");
			sql.append("	, member_detail.tel2	\n");
			sql.append("	, member_detail.tel3	\n");
			sql.append("	, member_detail.zipcode	\n");
			sql.append("	, member_detail.address	\n");
			sql.append("	, member_detail.address_detail	\n");
			sql.append("from member 	\n");
			sql.append("		 , member_detail 	\n");
			sql.append("where 	\n");
			sql.append(" 	member.id = member_detail.id 	\n");
			String key = map.get("key");
			String word = map.get("word");
			System.out.println(key + "  " + word);
			if(word != null && !word.isEmpty()) {
				if("id".equals(key)) {
					sql.append("	and member.id = ?	\n");
				} else {
					sql.append("	and member_detail." + key + " like '%' || ? || '%' \n");
				}
			}
			
			pstmt = con.prepareStatement(sql.toString());
			if(word != null && !word.isEmpty()) {
				pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();

			while(rs.next()) {
				MemberDetailDto memberDetailDto = new MemberDetailDto();
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setName(rs.getString("name"));;
				memberDetailDto.setEmailid(rs.getString("emailid"));
				memberDetailDto.setEmaildomain(rs.getString("emaildomain"));
				memberDetailDto.setJoindate(rs.getString("joindate"));
				memberDetailDto.setTel1(rs.getString("tel1"));
				memberDetailDto.setTel2(rs.getString("tel2"));
				memberDetailDto.setTel3(rs.getString("tel3"));
				memberDetailDto.setZipcode(rs.getString("zipcode"));
				memberDetailDto.setAddress(rs.getString("address"));
				memberDetailDto.setAddressDetail(rs.getString("address_detail"));
				
				list.add(memberDetailDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
	}

}
