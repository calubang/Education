package com.kitri.service;

import java.util.List;

import com.kitri.dao.RepBoardDAO;
import com.kitri.dto.RepBoard;
import com.kitri.exception.AddException;

public class RepBoardService {
	private RepBoardDAO dao;
	public RepBoardService() {
		dao = new RepBoardDAO();
	}
	
	public void write(RepBoard repBoard) throws AddException {
		//부모글번호를 체크해서 throw 하거나 강제로 부모글번호를 0으로 만들어준다
		repBoard.setParent_seq(0);
		dao.insert(repBoard);
	}
	
	public void reply(RepBoard repBoard) throws AddException {
		if(repBoard.getParent_seq() == 0)
			throw new AddException("부모글번호가 없는 답글입니다.");
		dao.insert(repBoard);
	}
	
	public List<RepBoard> findByRows(int startRow, int endRow){
		return dao.selectByRows(startRow, endRow);
	}

	public int calculateTotalPage() {
		return dao.getTotalRowCount();
	}
	
}
