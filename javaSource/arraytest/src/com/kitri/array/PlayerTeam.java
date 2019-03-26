package com.kitri.array;

public class PlayerTeam {
	
	public static void main(String[] args) {
		PlayerDto[] player= new PlayerDto[5];
		
		PlayerDto p1 = new PlayerDto(23, "권영찬", 4, 0.321);
		PlayerDto p2 = new PlayerDto(33, "이재운", 5, 0.351);
		PlayerDto p3 = new PlayerDto(32, "안병욱", 1, 0.001);
		PlayerDto p4 = new PlayerDto(26, "권범준", 3, 0.421);
		PlayerDto p5 = new PlayerDto(28, "이소담", 7, 0.384);
		
		player[0] = p1;
		player[1] = p2;
		player[2] = p3;
		player[3] = p4;
		player[4] = p5;
		
		int len = player.length;
		for (int i = 0; i < len; i++) {
			System.out.println(player[i]);
		}
	}
	
}