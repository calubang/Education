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
		baseBall.ta.append("\n------------ 숫 자 야 구--------------\n");
		baseBall.ta.append("숫자를 입력하세요 : ");
		baseBall.tf.setText("");
		baseBall.tf.setEnabled(true);
		comRandom();
	}
	
	public void game() {
		//boolean result = true;
		
		count++;
		
		String myNumber = baseBall.tf.getText().trim();
		if( !isCorrectInput(myNumber) ) {
			appendTextField("올바른 숫자를 입력하세요");
			appendTextField("숫자를 입력하세요 : ");
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
					//그밖에 경우엔 별거없듬
				}
			}
		}
		if(strike == 3) {
			appendTextField(count + "번째에 당신이 입력한 " + my[0] + my[1] + my [2] + "가 정답입니다.");
			count = 0;
			baseBall.tf.setEnabled(false);
			appendTextField("새로운 게임 or 종료를 눌러주세요.");
			
		}else{
			appendTextField(count + "번째 오답 : " + strike + " 스트라이크 " + ball + " 볼");
			baseBall.ta.append("숫자를 입력하세요 : ");	
		}
	}

	private void comRandom() {
		Random random = new Random();
		
		int length = com.length;
		com[0] = random.nextInt(9) + 1;
		for(int i = 1 ; i<length ; i++) {
			//1부터 난수발생
			com[i] = random.nextInt(10);
			//자기보다 앞에 있는 애들을 자기와 비교
			//비교중에 같은게 보이면 다시 난수발생해서 다시 처음부터 비교
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
		appendTextField("\n정답은 " + com[0] + com[1] + com[2] + " 입니다.");
		baseBallController.baseBall.tf.setEnabled(false);
		appendTextField("새로운 게임 or 종료를 눌러주세요.");
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
