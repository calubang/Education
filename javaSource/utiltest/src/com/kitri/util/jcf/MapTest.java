package com.kitri.util.jcf;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		
		//Map<Integer, PlayerDto> mapTest = new HashMap<Integer, PlayerDto>();
		Map<Integer, PlayerDto> mapTest = new Hashtable<Integer, PlayerDto>();
		
		PlayerDto p1 = new PlayerDto(23, "�ǿ���", 4, 0.321);
		PlayerDto p2 = new PlayerDto(33, "�����", 5, 0.351);
		PlayerDto p3 = new PlayerDto(32, "�Ⱥ���", 1, 0.001);
		PlayerDto p4 = new PlayerDto(27, "�ǹ���", 3, 0.421);
		PlayerDto p5 = new PlayerDto(28, "�̼Ҵ�", 7, 0.384);
		
		int size = mapTest.size();	
		System.out.println("��� �ο� : " + size);
		
		mapTest.put(p1.getNumber(), p1);
		mapTest.put(p2.getNumber(), p2);
		mapTest.put(p3.getNumber(), p3);
		mapTest.put(p4.getNumber(), p4);
		mapTest.put(p5.getNumber(), p5);
		
		size = mapTest.size();	
		System.out.println("��� �ο� : " + size);		
		
		int number = 23;
		System.out.println("�λ��� " + number + "���� ����!!!!");
		PlayerDto playerDto = mapTest.get(number);
		System.out.println(playerDto);
		
	}

}
