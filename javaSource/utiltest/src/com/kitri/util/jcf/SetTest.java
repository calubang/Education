package com.kitri.util.jcf;

import java.util.*;

public class SetTest {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		System.out.println("set �� ũ�� : " + set.size());
		set.add("Ȳ����");
		set.add("�ڹ̷�");
		set.add("������");
		set.add("������");
		set.add("�ڹ̷�");
		System.out.println("set �� ũ�� : " + set.size());
		
		String array[] = set.toArray(new String[0]);
		int len = array.length;
		for (int i = 0; i < len; i++) {
			System.out.println(array[i]);
		}
		
		System.out.println("-----------------------------------");
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
	}
}
