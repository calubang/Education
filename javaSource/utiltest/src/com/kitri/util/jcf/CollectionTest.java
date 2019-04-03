package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		
		//Collection col = new ArrayList();
		Collection col = new HashSet();
		System.out.println(col.size());
		col.add(new CollectionTest());
		col.add(new CollectionTest());
		col.add("권영찬");
		col.add("이소담");
		col.add("권범준");
		col.add(new Integer(0));
		System.out.println(col.size());
		
		Object ob[] = col.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println(ob[i]);
		}
		
	}
}
