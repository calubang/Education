package com.kitri.util.jcf;

import java.util.*;

public class ListTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println("size : " + list.size());
		
		list.add("����");
		list.add("������");
		list.add("�ڰǿ�");
		list.add("����ȯ");
		
		System.out.println("size : " + list.size());
		System.out.println("�λ��� Ÿ��");
		
//		Iterator<String>iter = list.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
		int size = list.size();
		for(int i = 0 ; i<size ; i++) {
			System.out.println((i+1) + "�� Ÿ�� : " + list.get(i));
		}
		
		String name = "������";
		String name2 = "�����";
		int index = list.indexOf(name);
		
		System.out.println(name + "�� " + (index+1) + "�� Ÿ�� �Դϴ�.");
		
		list.set(index, name2);
		
		System.out.println(name + "�� " + name2 + "���� ��ü");
		size = list.size();
		for(int i = 0 ; i<size ; i++) {
			System.out.println(i + "�� Ÿ�� : " + list.get(i));
		}
		
		
	}
}
