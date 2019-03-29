package com.kitri.awt.calcurator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame{
	
	//선언부
	public final int buttonAmount = 16;
	String bStr[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
	Button bDigit[] = new Button[buttonAmount];
	CalculatorController calculatorController;
	
	//awt
	//패널
	Panel pResult = new Panel();
	Panel pDigit = new Panel();
		
	//라벨
	Label lNum = new Label("0", Label.RIGHT);
	Label lOper = new Label("Oper", Label.CENTER);
		
	//버튼
	Button bExit = new Button("종료");
	
	public Calculator() {
		calculatorController = new CalculatorController(this);
		
		//배치부
		Font fNumber = new Font("Verdana", Font.BOLD, 30);
		pResult.setLayout(new BorderLayout(5,0));
		lNum.setBackground(hex2Rgb("#b2c3ca"));
		lOper.setBackground(hex2Rgb("#daeff8"));
		lNum.setFont(fNumber);
		lOper.setFont(fNumber);
		pResult.add(lNum, BorderLayout.CENTER);
		pResult.add(lOper, BorderLayout.EAST);
		
		//숫자패널
		pDigit.setLayout(new GridLayout(4, 4, 5, 5));
		for (int i = 0; i < buttonAmount; i++) {
			bDigit[i] = new Button(bStr[i]);
			bDigit[i].setFont(fNumber);
			bDigit[i].setBackground(hex2Rgb("#ecf7fc"));
			pDigit.add(bDigit[i]);
		}
		
		//하단
		bExit.setFont(fNumber);
		
		setLayout(new BorderLayout(0, 10));
		add(pDigit, BorderLayout.CENTER);
		add(pResult, BorderLayout.NORTH);
		add(bExit, BorderLayout.SOUTH);
		setBounds(300, 200, 500, 500);
		this.setVisible(true);
		
		//리스너 등록
		for(int i = 0 ; i<buttonAmount ; i++) {
			bDigit[i].addActionListener(calculatorController);
		}
		bExit.addActionListener(calculatorController);
		
		
		WindowAdapter wa = new WindowAdapter() {
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(wa);
	}
	
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
