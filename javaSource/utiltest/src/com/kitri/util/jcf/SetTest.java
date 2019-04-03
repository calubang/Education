package com.kitri.util.jcf;

import java.util.*;

public class SetTest {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		System.out.println("set 의 크기 : " + set.size());
		set.add("황선혜");
		set.add("박미래");
		set.add("이혜린");
		set.add("조윤영");
		set.add("박미래");
		System.out.println("set 의 크기 : " + set.size());
		
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
