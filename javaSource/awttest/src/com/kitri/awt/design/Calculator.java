package com.kitri.awt.design;

import java.awt.*;

public class Calculator extends Frame {

	Button bDigit[] = new Button[16];
	String bStr[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
	
	//UI
	//패널
	Panel pResult = new Panel();
	Panel pDigit = new Panel();
	
	//라벨
	Label lNum = new Label("num", Label.RIGHT);
	Label lOper = new Label("oper", Label.CENTER);
	
	//버튼
	Button bExit = new Button("종        료");
	
	public Calculator() {
		//결과패널
		pResult.setLayout(new BorderLayout(10,10));
		lNum.setBackground(Color.GRAY);
		lOper.setBackground(Color.GRAY);
		pResult.add(lNum, BorderLayout.CENTER);
		pResult.add(lOper, BorderLayout.EAST);
		
		//숫자패널
		pDigit.setLayout(new GridLayout(4, 4, 10, 10));
		int len = bDigit.length;
		for (int i = 0; i < len; i++) {
			pDigit.add(new Button(bStr[i]));
		}
		
		setLayout(new BorderLayout(10, 10));
		add(pDigit, BorderLayout.CENTER);
		add(pResult, BorderLayout.NORTH);
		add(bExit, BorderLayout.SOUTH);
		
		setBounds(300, 200, 500, 500);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
