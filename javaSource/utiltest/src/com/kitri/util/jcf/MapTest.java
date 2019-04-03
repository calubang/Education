package com.kitri.util.jcf;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		
		//Map<Integer, PlayerDto> mapTest = new HashMap<Integer, PlayerDto>();
		Map<Integer, PlayerDto> mapTest = new Hashtable<Integer, PlayerDto>();
		
		PlayerDto p1 = new PlayerDto(23, "권영찬", 4, 0.321);
		PlayerDto p2 = new PlayerDto(33, "이재운", 5, 0.351);
		PlayerDto p3 = new PlayerDto(32, "안병욱", 1, 0.001);
		PlayerDto p4 = new PlayerDto(27, "권범준", 3, 0.421);
		PlayerDto p5 = new PlayerDto(28, "이소담", 7, 0.384);
		
		int size = mapTest.size();	
		System.out.println("등록 인원 : " + size);
		
		mapTest.put(p1.getNumber(), p1);
		mapTest.put(p2.getNumber(), p2);
		mapTest.put(p3.getNumber(), p3);
		mapTest.put(p4.getNumber(), p4);
		mapTest.put(p5.getNumber(), p5);
		
		size = mapTest.size();	
		System.out.println("등록 인원 : " + size);		
		
		int number = 23;
		System.out.println("두산의 " + number + "번의 정보!!!!");
		PlayerDto playerDto = mapTest.get(number);
		System.out.println(playerDto);
		
	}

}
