package com.kitri.awt.event;

import java.awt.*;
import java.util.Random;

public class BaseBallService {
	
	BaseBallController baseBallController;
	private FontColorChooser fontColorChooser;
	private BaseBall baseBall;
	
	private final int digit = 3;
	private int[] com;
	private int[] my;
	int count = 0;
	int r,g,b;
	
	
	public BaseBallService(BaseBallController baseBallController) {
		this.baseBallController = baseBallController;
		fontColorChooser = baseBallController.baseBall.fontColorChooser;
		baseBall = baseBallController.baseBall;
		com = new int[digit];
		my  = new int[digit];
		newGame();
	}

	public void newGame() {
		BaseBall baseBall = baseBallController.baseBall;
		baseBall.ta.setText("-------------------------------------");
		baseBall.ta.append("\n------------ �� �� �� ��--------------\n");
		baseBall.ta.append("���ڸ� �Է��ϼ��� : ");
		baseBall.tf.setText("");
		baseBall.tf.setEnabled(true);
		comRandom();
	}
	
	public void game() {
		//boolean result = true;
		
		count++;
		
		String myNumber = baseBall.tf.getText().trim();
		if( !isCorrectInput(myNumber) ) {
			appendTextField("�ùٸ� ���ڸ� �Է��ϼ���");
			appendTextField("���ڸ� �Է��ϼ��� : ");
			baseBall.tf.setText("");
			return;
		}
		baseBall.tf.setText("");
		baseBall.ta.append(myNumber + "\n");
		
		int len = my.length;
		for(int i = 0 ; i<len ; i++) {
			my[i] = myNumber.charAt(i) - 48;
		}
		
		gameResult();
	}
	
	private void gameResult() {
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
			appendTextField(count + "��°�� ����� �Է��� " + my[0] + my[1] + my [2] + "�� �����Դϴ�.");
			count = 0;
			baseBall.tf.setEnabled(false);
			appendTextField("���ο� ���� or ���Ḧ �����ּ���.");
			
		}else{
			appendTextField(count + "��° ���� : " + strike + " ��Ʈ����ũ " + ball + " ��");
			baseBall.ta.append("���ڸ� �Է��ϼ��� : ");	
		}
	}

	private void comRandom() {
		Random random = new Random();
		
		int length = com.length;
		com[0] = random.nextInt(9) + 1;
		for(int i = 1 ; i<length ; i++) {
			//1���� �����߻�
			com[i] = random.nextInt(10);
			//�ڱ⺸�� �տ� �ִ� �ֵ��� �ڱ�� ��
			//���߿� ������ ���̸� �ٽ� �����߻��ؼ� �ٽ� ó������ ��
			for(int j = 0 ; j < i ; j++) {
				if(com[j] == com[i]) {
					com[i] = random.nextInt(10);
					j = 0;
				}	
			}
		}
	}
	
	private boolean isCorrectInput(String str) {
		int len = str.length(); 
		if(len != my.length) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				return false;
			}
		}	
		return true;
	}
	
	private void appendTextField(String msg) {
		TextArea ta = baseBallController.baseBall.ta;
		ta.append(msg+"\n");
	}

	public void clear() {
		baseBallController.baseBall.ta.setText(" ");
	}

	public void showDap() {
		appendTextField("\n������ " + com[0] + com[1] + com[2] + " �Դϴ�.");
		baseBallController.baseBall.tf.setEnabled(false);
		appendTextField("���ο� ���� or ���Ḧ �����ּ���.");
	}

	public void fontColorChange() {
		if( !fontColorChooser.isVisible()) {
			Rectangle rectangle = baseBall.getBounds();
			fontColorChooser.setBounds(rectangle.x+rectangle.width+50, rectangle.y, 500, 500);;
			fontColorChooser.setVisible(true);
		} else {
			fontColorChooser.setVisible(false);
		}
		changeColor();
	}

	public void exit() {
		System.exit(0);
		
	}
	
	public void changeColor() {
		r = fontColorChooser.sbR.getValue();
		g = fontColorChooser.sbG.getValue();
		b = fontColorChooser.sbB.getValue();
		fontColorChooser.pColor.setBackground(new Color(r, g, b));
		fontColorChooser.lColor.setText("R:" + r + "   G:" + g + "   B:" + b);
	}

	public void selectColor() {
		baseBall.ta.setForeground(new Color(r,g,b));
		//fontColorChooser.setVisible(false);
	}
	
}
