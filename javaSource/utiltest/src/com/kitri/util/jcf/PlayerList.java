package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
	
	public List<PlayerDto> playerList = new ArrayList<PlayerDto>();
	
	public PlayerDto searchPlayer(int number) {
		int size = playerList.size();
		PlayerDto playerDto = null;
		for (int i = 0; i < size; i++) {
			playerDto = playerList.get(i);
			if(playerDto.getNumber() == number) {
				return playerDto;
			}
		}
		return null;
	}
	
	public void playerRegister(PlayerDto playerDto) {
		playerList.add(playerDto);
	}
	
	public void playerList() {
		System.out.println("-------------------------------------------------------------------------------------------------");
		int size = playerList.size();
		for (int i = 0; i < size; i++) {
			System.out.println(playerList.get(i));
		}
	}
	
	public void playerInfo(PlayerDto playerDto) {
		System.out.println("------------------------------선수정보---------------------------------");
		if(playerDto == null) {
			System.out.println("선수 없습니다.");
		}else {
			System.out.println(playerDto);
		}
	}
	
	public static void main(String[] args) {
		
		//List<PlayerDto> playerList = new ArrayList<PlayerDto>();
		PlayerDto p1 = new PlayerDto(23, "권영찬", 4, 0.321);
		PlayerDto p2 = new PlayerDto(33, "이재운", 5, 0.351);
		PlayerDto p3 = new PlayerDto(32, "안병욱", 1, 0.001);
		PlayerDto p4 = new PlayerDto(26, "권범준", 3, 0.421);
		PlayerDto p5 = new PlayerDto(28, "이소담", 7, 0.384);
		
		PlayerList playerList = new PlayerList();
		
		playerList.playerRegister(p1);
		playerList.playerRegister(p2);
		playerList.playerRegister(p3);
		playerList.playerRegister(p4);
		playerList.playerRegister(p5);
		
		playerList.playerList();
		
		int number = 28;
		PlayerDto playerDto = null;
		System.out.println(number + "번 선수 정보!!");
		playerDto = playerList.searchPlayer(number);
		if(playerDto == null) {
			System.out.println(number + "번 선수를 찾을 수 없습니다.");
		}else {
			playerList.playerInfo(playerDto);
		}
		
		number = 26;
		double score = 0.357;
		System.out.println(number + "번 선수가 안타!!! 타율이 " + score + "로 변경되었습니다.");
		playerDto =  playerList.searchPlayer(number);
		if(playerDto != null) {
			playerList.setPlayerGrade(playerDto, score);
		}
		playerList.playerInfo(playerDto);
		
	}
	
	public double setPlayerGrade(PlayerDto playerDto, double score) {
		double grade = playerDto.getGrade();
		playerDto.setGrade(score);
		return grade;
	}
	
}
