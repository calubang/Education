package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {
	public static void main(String[] args) {
		Drama winterTheWind = new Drama("그 겨울, 바람이 분다", "SBS", "김규태", "조인성", "송혜교");
		Drama heritageOfHundred = new Drama("백년의 유산", "MBC", "주성우", "", "");
		Drama iris2 = new Drama("아이리스2", "KBS", "표민수", "장혁", "이다해");
		Drama bestYiSunsin = new Drama("최고다 이순신", "KBS", "윤성식", "", "아이유");
		
		List<Drama> dramaList = new ArrayList<Drama>();
		
		dramaList.add(winterTheWind);
		dramaList.add(heritageOfHundred);
		dramaList.add(iris2);
		dramaList.add(bestYiSunsin);
		
		int size = dramaList.size();
		for(int i =0 ; i<size ; i++) {
			System.out.println((i+1) + ". " + dramaList.get(i)+"\n");
		}
	}
}
