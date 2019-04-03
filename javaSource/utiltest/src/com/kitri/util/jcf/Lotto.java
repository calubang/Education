package com.kitri.util.jcf;

import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		
		Random ran = new Random();
		Set<Integer> set = new HashSet<Integer>();
		set.add(ran.nextInt(45) + 1);
		
		
		do {
			set.add(ran.nextInt(45) + 1);
		}while(set.size() < 6);
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}
}
