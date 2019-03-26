package com.kitri.array;
// 0. com, my 3�ڸ� �迭
// 1. com ���ڸ� ���� �߻� > comRandom()
// 2. ���ڴ� �ߺ� ���� X
//                0���� ���� x
// 3. ���� �Է��� 3�ڸ� ���ڸ� my �迭�� �ֱ�
// 4. ���ΰ��� ���ڿ� �ڸ���
// 5. ���ڰ� ���ٸ�
//    5-1. �ڸ����� ���ٸ� strike ����
//    5-2. �ڸ����� �ٸ��ٸ� ball ����
//6. ���ڰ� ��ΰ� �ٸ��ٸ� �ƿ�~
//7. strike����
//   7-1. 3�� : x��°. ����� �Է��� xxx �� �����Դϴ�. x��°���� ����!
//   7-2. 3�� : x��°. ����� �Է��� xxx�� x��Ʈ����ũ x���Դϴ�. -> 3������ ���� �ٽ� �Է�
//8. ���(1),  ����(0)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.java2d.pipe.BufferedBufImgOps;

public class NumberBaseBall {
	
	private final int digit = 3;
	private int[] com = new int[digit];
	private int[] my = new int[digit];
	BufferedReader in;
	
	//������
	public NumberBaseBall() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//method
	//���ӽ���
	public void gameStart() {
		System.out.println("-------------------------------------------------");
		System.out.println("------------------ �� �� �� ��--------------------");
		menu();
	}
	
	public void menu() {
		int menuInput = 0;
		while(menuInput != 2) {
			System.out.println("1. ���ӽ���   |   2. �������� ");
			System.out.print("�޴��� �����ϼ��� : ");
			menuInput = getNumber();
			switch(menuInput) {
			case 1:
				//���ӽ���
				game();
				break;
			case 2:
				//��������
				System.out.println("������ �����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("�߸� �����˽��ϴ�.");
			}
		}
	}
	
	private void game() {
		boolean result = true;
		int count = 0;
		//�����߻�
		comRandom();
		while(result) {
			count++;
			for(int i = 0; i<digit ; i++) {
				System.out.print(com[i]);
			}
			System.out.println("");
			System.out.print("���ڸ� �Է��ϼ��� : ");
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
					//�׹ۿ� ��쿣 ���ž���
				}
			}
		}
		if(strike == 3) {
			System.out.println(count + "��°�� ����� �Է��� " +my[0] + my[1] + my[2] + "�� �����Դϴ�.");
			return false;
		}else{
			System.out.println(count + "��° ���� : " + strike + " ��Ʈ����ũ " + ball + " ��");
			return true;
		}
	}
	
	private void comRandom() {
		int length = com.length;
		com[0] = (int)(Math.random() * 9 + 1);
		for(int i = 1 ; i<length ; i++) {
			//1���� �����߻�
			com[i] = (int)(Math.random() * 10);
			//�ڱ⺸�� �տ� �ִ� �ֵ��� �ڱ�� ��
			//���߿� ������ ���̸� �ٽ� �����߻��ؼ� �ٽ� ó������ ��
			for(int j = 0 ; j < i ; j++) {
				if(com[j] == com[i]) {
					com[i] = (int)(Math.random() * 10);
					j = 0;
				}	
			}
		}
	}
	
	//����üũ
	private boolean numberCheck(int input) {
		//�ڸ��� üũ
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
