package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.*;

public class Calculator extends Frame {

	private final int buttonAmount = 16;
	Button bDigit[] = new Button[buttonAmount];
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
			Button button = new Button(bStr[i]);
			button.setFont(fNumber);
			button.setBackground(hex2Rgb("#ecf7fc"));
			pDigit.add(button);
		}
		//종료
		bExit.setFont(fNumber);;
		
		setLayout(new BorderLayout(5, 10));
		add(pDigit, BorderLayout.CENTER);
		add(pResult, BorderLayout.NORTH);
		add(bExit, BorderLayout.SOUTH);
		setBounds(300, 200, 500, 500);
		this.setVisible(true);
		
		WindowAdapter wa = new WindowAdapter() {
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		
		int len = pDigit.getComponentCount();
		for(int i = 0 ; i<len ; i++) {
			//pDigit.getComponent(i);
			System.out.println(pDigit.getComponent(i).getName());
		}
		
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
