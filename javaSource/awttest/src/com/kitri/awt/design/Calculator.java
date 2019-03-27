package com.kitri.awt.design;

import java.awt.*;

public class Calculator extends Frame {

	Button bDigit[] = new Button[16];
	String bStr[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
	
	//UI
	//�г�
	Panel pResult = new Panel();
	Panel pDigit = new Panel();
	
	//��
	Label lNum = new Label("num", Label.RIGHT);
	Label lOper = new Label("oper", Label.CENTER);
	
	//��ư
	Button bExit = new Button("��        ��");
	
	public Calculator() {
		//����г�
		pResult.setLayout(new BorderLayout(10,10));
		lNum.setBackground(Color.GRAY);
		lOper.setBackground(Color.GRAY);
		pResult.add(lNum, BorderLayout.CENTER);
		pResult.add(lOper, BorderLayout.EAST);
		
		//�����г�
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
