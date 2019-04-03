package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {
	public static void main(String[] args) {
		Drama winterTheWind = new Drama("�� �ܿ�, �ٶ��� �д�", "SBS", "�����", "���μ�", "������");
		Drama heritageOfHundred = new Drama("����� ����", "MBC", "�ּ���", "", "");
		Drama iris2 = new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���");
		Drama bestYiSunsin = new Drama("�ְ�� �̼���", "KBS", "������", "", "������");
		
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
