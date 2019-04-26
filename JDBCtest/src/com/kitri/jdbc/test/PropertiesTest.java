package com.kitri.jdbc.test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(new File("src\\com\\kitri\\jdbc\\test\\test.properties")));
			String name = prop.getProperty("name_kor");
			System.out.println(name);
			
			name = prop.getProperty("name_en");
			System.out.println(name);
			
			name = prop.getProperty("name_cn");
			System.out.println(name);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
