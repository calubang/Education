package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;
import com.kitri.util.DBClose;
import com.kitri.util.DBConnection;

public class RepBoardDAO {
	
	
	
	public void insert(RepBoard repBoard) throws AddException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertSQL = 
				"insert into repboard(\n"
				+ "board_seq\n"
				+ ", parent_seq\n"
				+ ", board_subject\n"
				+ ", board_writer\n"
				+ ", board_contents\n"
				+ ", board_date\n"
				+ ", board_password\n"
				+ ", board_viewcount\n"
				+ ") values("
				+ "repboard_seq.nextval		\n"
				+ ", ?	\n"
				+ ", ?	\n"
				+ ", ?	\n"
				+ ", ?	\n"
				+ ", systimestamp	\n"
				+ ", ?	\n"
				+ ", 0	\n"
				+ ")\n";
		
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(insertSQL);
			int index = 0;
			pstmt.setInt(++index, repBoard.getParent_seq());
			pstmt.setString(++index, repBoard.getBoard_subject());
			pstmt.setString(++index, repBoard.getBoard_writer());
			pstmt.setString(++index, repBoard.getBoard_contents());
			pstmt.setString(++index, repBoard.getBoard_password());
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException();
		} finally {
			DBClose.close(con, pstmt);
		}
	}
	
	public List<RepBoard> selectByRows(int startRow, int endRow){
		List<RepBoard> list = new ArrayList<RepBoard>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectByRowsSQL = 
				"select *\r\n" + 
				"from (\r\n" + 
				"    select \r\n" + 
				"        rownum board_rownum\r\n" + 
				"		 , level	\r\n"	+
				"        , board_seq\r\n" + 
				"        , parent_seq\r\n" + 
				"        , repboard.board_subject\r\n" + 
				"        , repboard.board_writer\r\n" + 
				"        , repboard.board_contents\r\n" + 
				"        , repboard.board_date\r\n" + 
				"        , repboard.board_password\r\n" + 
				"        , repboard.board_viewcount\r\n" + 
				"    from repboard\r\n" + 
				"    start with parent_seq = 0\r\n" + 
				"    connect by prior board_seq = parent_seq\r\n" + 
				"    order SIBLINGS by board_seq desc\r\n" + 
				"    )\r\n" + 
				"where board_rownum BETWEEN ? and ?";
		
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(selectByRowsSQL);
			int index = 0;
			pstmt.setInt(++index, startRow);
			pstmt.setInt(++index, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RepBoard repBoard = new RepBoard();
				repBoard.setBoard_seq(rs.getInt("board_seq"));
				repBoard.setParent_seq(rs.getInt("parent_seq"));
				repBoard.setLevel(rs.getInt("level"));
				repBoard.setBoard_subject(rs.getString("board_subject"));
				repBoard.setBoard_contents(rs.getString("board_contents"));
				repBoard.setBoard_writer(rs.getString("board_writer"));
				repBoard.setBoard_date(rs.getTimestamp("board_date"));
				repBoard.setBoard_password(rs.getString("board_password"));
				repBoard.setBoard_viewcount(rs.getInt("board_viewcount"));
								
				list.add(repBoard);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	public int getTotalRowCount() {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String getTotalRowCountSQL = 
				"select\r\n" + 
				"    count(board_seq) totalrowcount\r\n" + 
				"from repboard";
		
		try {
			con = DBConnection.makeConnection();
			pstmt = con.prepareStatement(getTotalRowCountSQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("totalrowcount");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		/*
		 * RepBoard repBoard = new RepBoard(); repBoard.setParent_seq(0);
		 * repBoard.setBoard_subject("제목입니다"); repBoard.setBoard_writer("calubang");
		 * repBoard.setBoard_contents("본문입니다."); repBoard.setBoard_password("123"); try
		 * { new RepBoardDAO().insert(repBoard); } catch (AddException e) {
		 * e.printStackTrace(); }
		 */
		
		for(RepBoard repBoard : new RepBoardDAO().selectByRows(1, 5)) {
			System.out.println(repBoard);
		}
	}

	
}
