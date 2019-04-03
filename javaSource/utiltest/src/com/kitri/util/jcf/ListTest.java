package com.kitri.util.jcf;

import java.util.*;

public class ListTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println("size : " + list.size());
		
		list.add("허경민");
		list.add("정수빈");
		list.add("박건우");
		list.add("김재환");
		
		System.out.println("size : " + list.size());
		System.out.println("두산의 타순");
		
//		Iterator<String>iter = list.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
		int size = list.size();
		for(int i = 0 ; i<size ; i++) {
			System.out.println((i+1) + "번 타자 : " + list.get(i));
		}
		
		String name = "정수빈";
		String name2 = "오재원";
		int index = list.indexOf(name);
		
		System.out.println(name + "은 " + (index+1) + "번 타자 입니다.");
		
		list.set(index, name2);
		
		System.out.println(name + "을 " + name2 + "으로 교체");
		size = list.size();
		for(int i = 0 ; i<size ; i++) {
			System.out.println(i + "번 타자 : " + list.get(i));
		}
		
		
	}
}
