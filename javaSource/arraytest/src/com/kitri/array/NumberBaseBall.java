package com.kitri.array;
// 0. com, my 3자리 배열
// 1. com 세자리 난수 발생 > comRandom()
// 2. 숫자는 중복 숫자 X
//                0으로 시작 x
// 3. 내가 입력한 3자리 숫자를 my 배열에 넣기
// 4. 서로간의 숫자와 자리비교
// 5. 숫자가 같다면
//    5-1. 자리수가 같다면 strike 증가
//    5-2. 자리수가 다르다면 ball 증가
//6. 숫자가 모두가 다르다면 아웃~
//7. strike개수
//   7-1. 3개 : x번째. 당신이 입력한 xxx 는 정답입니다. x번째만에 정답!
//   7-2. 3개 : x번째. 당신이 입력한 xxx는 x스트라이크 x볼입니다. -> 3번으로 가서 다시 입력
//8. 계속(1),  종료(0)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.java2d.pipe.BufferedBufImgOps;

public class NumberBaseBall {
	
	private final int digit = 3;
	private int[] com = new int[digit];
	private int[] my = new int[digit];
	BufferedReader in;
	
	//생성자
	public NumberBaseBall() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//method
	//게임시작
	public void gameStart() {
		System.out.println("-------------------------------------------------");
		System.out.println("------------------ 숫 자 야 구--------------------");
		menu();
	}
	
	public void menu() {
		int menuInput = 0;
		while(menuInput != 2) {
			System.out.println("1. 게임시작   |   2. 게임종료 ");
			System.out.print("메뉴를 선택하세요 : ");
			menuInput = getNumber();
			switch(menuInput) {
			case 1:
				//게임시작
				game();
				break;
			case 2:
				//게임종료
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못 누르셧습니다.");
			}
		}
	}
	
	private void game() {
		boolean result = true;
		int count = 0;
		//난수발생
		comRandom();
		while(result) {
			count++;
			for(int i = 0; i<digit ; i++) {
				System.out.print(com[i]);
			}
			System.out.println("");
			System.out.print("숫자를 입력하세요 : ");
			int myInput = getNumber();
			int tempMyInput = myInput;
			for(int i =0 ; i<digit ; i++) {
				if((digit-i-1) != 0){
					my[i] = tempMyInput/ (int)Math.pow(10, (digit-i-1) );
					tempMyInput %= (my[i]* (int)Math.pow(10, (digit-i-1) ));
				}else
					my[i] = tempMyInput;
			}
			result = gameResult(count);
		}
	}
	
	private boolean gameResult(int count) {
		int strike = 0;
		int ball = 0;
		for(int com = 0 ; com < digit ; com++) {
			for(int my = 0 ; my < digit ; my++) {
				if((this.com[com] == this.my[my]) && (com != my)) {
					ball++;
				} else if((this.com[com] == this.my[my]) && (com == my)) {
					strike++;
				} else{
					//그밖에 경우엔 별거없듬
				}
			}
		}
		if(strike == 3) {
			System.out.println(count + "번째에 당신이 입력한 " +my[0] + my[1] + my[2] + "가 정답입니다.");
			return false;
		}else{
			System.out.println(count + "번째 오답 : " + strike + " 스트라이크 " + ball + " 볼");
			return true;
		}
	}
	
	private void comRandom() {
		int length = com.length;
		com[0] = (int)(Math.random() * 9 + 1);
		for(int i = 1 ; i<length ; i++) {
			//1부터 난수발생
			com[i] = (int)(Math.random() * 10);
			//자기보다 앞에 있는 애들을 자기와 비교
			//비교중에 같은게 보이면 다시 난수발생해서 다시 처음부터 비교
			for(int j = 0 ; j < i ; j++) {
				if(com[j] == com[i]) {
					com[i] = (int)(Math.random() * 10);
					j = 0;
				}	
			}
		}
	}
	
	//숫자체크
	private boolean numberCheck(int input) {
		//자리수 체크
		if( (int)(input / (int)Math.pow(10, digit)) != 0) {
			return false;
		}
		
		for(int i = 1 ; i<digit ; i++) {
			for(int j = 0 ; j<i ; j++) {
				if(my[i] == my[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private int getNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		} catch( IOException e) {
			e.printStackTrace();
		}
		return num;
	}
		
	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.gameStart();
	}
	
	
}
