package com.kitri.service;

import com.kitri.dao.CustomerDao;
import com.kitri.dto.Customer;
import com.kitri.exception.NotFoundException;

public class CustomerService {
	
	private static CustomerDao dao;
	
	static {
		dao = new CustomerDao();
	}

	public static int login(String id, String pass) {
		int result = -1;
		
		try {
			Customer customer = dao.selectById(id);
			if(customer.getPass().equals(pass)) {
				result = 1;
				return result;
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
