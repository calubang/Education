package com.kitri.member.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	private MemberDaoImpl() {}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String searchId) {
		int cnt = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) as count \n");
			sql.append("from member \n");
			sql.append("where id = ?");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, searchId);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("count");
			
		} catch (SQLException e) {
			cnt = 1;
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public List<ZipcodeDto> zipSearch(String searchAddress) {
		List<ZipcodeDto> list = new ArrayList<ZipcodeDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select 	case  \n");
			sql.append("			when length(new_post_code) = 4 then '0'||new_post_code \n");
			sql.append("			else new_post_code \n");
			sql.append("		end zipcode,  \n");
			sql.append("		sido_kor sido, gugun_kor gugun,  \n");
			sql.append("		nvl(upmyon_kor, ' ') upmyon, doro_kor doro,  \n");
			sql.append("		case when building_refer_number != '0' \n");
			sql.append("			then building_origin_number||'-'||building_refer_number  \n");
			sql.append("			else trim(to_char(building_origin_number, '99999')) \n");
			sql.append("		end building_number, sigugun_building_name \n");
			sql.append("from 	postcode \n");
			sql.append("where 	doro_kor like '%'||?||'%' \n");
			sql.append("or sigugun_building_name like '%'||?||'%' \n");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, searchAddress);
			pstmt.setString(++index, searchAddress);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipcodeDto dto = new ZipcodeDto();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setUpmyon(rs.getString("upmyon"));
				dto.setDoro(rs.getString("doro"));
				dto.setBuildingNumber(rs.getString("building_number"));
				dto.setSigugunBuildingName(rs.getString("sigugun_building_name"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public int registerMember(MemberDetailDto dto) {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all     \n");
			sql.append("	into member(    \n");
			sql.append("	id    \n");
			sql.append("	, name    \n");
			sql.append("	, pass    \n");
			sql.append("	, emailid    \n");
			sql.append("	, emaildomain    \n");
			sql.append("	, joindate    \n");
			sql.append("	) values (    \n");
			sql.append("		?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, sysdate    \n");
			sql.append("	)    \n");
			sql.append("	into member_detail(    \n");
			sql.append("		id    \n");
			sql.append("		, zipcode    \n");
			sql.append("		, address    \n");
			sql.append("		, address_detail    \n");
			sql.append("		, tel1    \n");
			sql.append("		, tel2    \n");
			sql.append("		, tel3    \n");
			sql.append("	) values (    \n");
			sql.append("		?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("		, ?    \n");
			sql.append("	)    \n");
			sql.append("select * from dual\n");
			
			
			pstmt = con.prepareStatement(sql.toString());
			int index=0;
			pstmt.setString(++index, dto.getId());
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getPass());
			pstmt.setString(++index, dto.getEmailid());
			pstmt.setString(++index, dto.getEmaildomain());
			pstmt.setString(++index, dto.getId());
			pstmt.setString(++index, dto.getZipcode());
			pstmt.setString(++index, dto.getAddress());
			pstmt.setString(++index, dto.getAddressDetail());
			pstmt.setString(++index, dto.getTel1());
			pstmt.setString(++index, dto.getTel2());
			pstmt.setString(++index, dto.getTel3());
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt);
		}
		
		return cnt;
	}

	@Override
	public MemberDto loginMember(Map<String, String> loginInfo) {
		MemberDto memberDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select	\n");
			sql.append("	id	\n");
			sql.append("	, name	\n");
			sql.append("	, emailid	\n");
			sql.append("	, emaildomain	\n");
			sql.append("	, joindate	\n");
			sql.append("from member	\n");
			sql.append("where 	\n");
			sql.append("	id = ?	\n");
			sql.append("	and pass = ?	\n");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, loginInfo.get("userId"));
			pstmt.setString(++index, loginInfo.get("userPass"));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));;
				memberDto.setEmailid(rs.getString("emailid"));
				memberDto.setEmaildomain(rs.getString("emaildomain"));
				memberDto.setJoindate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return memberDto;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			con.setAutoCommit(false);
			
			//member_detail 시작
			sql.append("update MEMBER_DETAIL	\n");
			sql.append("set	\n");
			sql.append("	ZIPCODE = ?	\n");
			sql.append("	, ADDRESS = ?	\n");
			sql.append("	, ADDRESS_DETAIL = ?	\n");
			sql.append("	, TEL1 = ?	\n");
			sql.append("	, TEL2 = ?	\n");
			sql.append("	, TEL3 = ?	\n");
			sql.append("where	\n");
			sql.append("	id = ?	\n");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, dto.getZipcode());
			pstmt.setString(++index, dto.getAddress());
			pstmt.setString(++index, dto.getAddressDetail());
			pstmt.setString(++index, dto.getTel1());
			pstmt.setString(++index, dto.getTel2());
			pstmt.setString(++index, dto.getTel3());
			pstmt.setString(++index, dto.getId());

			result = pstmt.executeUpdate();
			if(result != 1) {
				return 0;
			}
			
			pstmt.close();
			sql.delete(0, sql.length());
			
			//member 시작
			sql.append("update MEMBER       		\n");
			sql.append("set       						\n");
			sql.append("	name = ?       			\n");
			sql.append("	, pass = ?       			\n");
			sql.append("	, EMAILID = ?       		\n");
			sql.append("	, EMAILDOMAIN = ?     \n");
			sql.append("where        					\n");
			sql.append("	id = ?       					\n");
			
			pstmt = con.prepareStatement(sql.toString());
			index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getPass());
			pstmt.setString(++index, dto.getEmailid());
			pstmt.setString(++index, dto.getEmaildomain());
			pstmt.setString(++index, dto.getId());
			
			result = pstmt.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			DBClose.close(con, pstmt);
		}
		return result;
	}

	@Override
	public int deleteMember(String id) {
		return 0;
	}

	@Override
	public MemberDetailDto passCheck(String id, String pass) {
		MemberDetailDto memberDetailDto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select	\n");
			sql.append("	member.id	\n");
			sql.append("	, member.name	\n");
			sql.append("	, member.pass	\n");
			sql.append("	, member.emailid	\n");
			sql.append("	, member.emaildomain	\n");
			sql.append("	, member.joindate	\n");
			sql.append("	, member_detail.zipcode	\n");
			sql.append("	, member_detail.address	\n");
			sql.append("	, member_detail.address_detail	\n");
			sql.append("	, member_detail.tel1	\n");
			sql.append("	, member_detail.tel2	\n");
			sql.append("	, member_detail.tel3	\n");
			sql.append("from	\n");
			sql.append("	member\n");
			sql.append("	, MEMBER_DETAIL	\n");
			sql.append("where \n");
			sql.append("	member.id = MEMBER_DETAIL.ID	\n");
			sql.append("	and member.id = ?	\n");
			sql.append("	and member.pass = ?	\n");

			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, id);
			pstmt.setString(++index, pass);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberDetailDto = new MemberDetailDto();
				memberDetailDto.setId(rs.getString("id"));
				memberDetailDto.setPass(rs.getString("pass"));
				memberDetailDto.setName(rs.getString("name"));;
				memberDetailDto.setEmailid(rs.getString("emailid"));
				memberDetailDto.setEmaildomain(rs.getString("emaildomain"));
				memberDetailDto.setJoindate(rs.getString("joindate"));
				memberDetailDto.setZipcode(rs.getString("zipcode"));
				memberDetailDto.setAddress(rs.getString("address"));
				memberDetailDto.setAddressDetail(rs.getString("address_detail"));
				memberDetailDto.setTel1(rs.getString("tel1"));
				memberDetailDto.setTel2(rs.getString("tel2"));
				memberDetailDto.setTel3(rs.getString("tel3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return memberDetailDto;
	}

}
