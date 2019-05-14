package com.kitri.service;

import com.kitri.dao.CustomerDao;
import com.kitri.dao.NotFoundException;
import com.kitri.dto.Customer;

public class CustomerService {
	
	private static CustomerDao dao;
	
	static {
		dao = new CustomerDao();
	}

	public static String login(String id, String pass) {
		String result = "Login 실패하였습니다.";
		
		try {
			Customer customer = dao.selectById(id);
			if(customer.getPass().equals(pass)) {
				result = "Login 성공하였습니다.";
				return result;
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
	}
}
