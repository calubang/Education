package com.kitri.haksa.db;

public class DaoFactory {
	public static ConnectionMaker connectionMaker(String name) { 
		
		switch(name) {
		case "oracle":
			return new OracleConnectionMaker();
		case "mysql":
			return new MysqlConnectionMaker();
		}
		return null;
	}
	public static Object getDao(String name) {
		
		switch(name) {
		case "haksa":
			return new HaksaDao(connectionMaker("oracle"));
		
		}
		return null;
	}
	
}