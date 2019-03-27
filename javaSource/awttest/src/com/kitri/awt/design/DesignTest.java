package com.kitri.awt.design;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

// 1. Frame 상속
// 2. 선언부에 필요한 객체 생성(생성자에서 해도 무방)
// 3. 배치부에서 design (component 배치)
//     3-1 배치부의 마지막은 언제나 setVisible
// 4. 작업은 작은거 -> 큰거
import java.awt.*;

public class DesignTest extends Frame{
	//선언부
	Panel pNorth = new Panel();
	Panel pSouth = new Panel();
	
	Label l = new Label("입력", Label.CENTER);
	TextField tf =  new TextField();
	Button bSend = new Button("전송");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button bExit = new Button("종료");
	
	//배치부
	public DesignTest() {
		super("디자인 테스트입니당.");
		
		pNorth.setLayout(new BorderLayout(10, 0));
		pNorth.add(l, BorderLayout.WEST);
		l.setBackground(new Color(210, 105, 107));
		l.setForeground(Color.ORANGE);
		Font f = new Font("Verdana", Font.BOLD, 20);
		l.setFont(f);
		pNorth.add(tf, BorderLayout.CENTER);
		bSend.setFont(f);
		pNorth.add(bSend, BorderLayout.EAST);
				
		pSouth.setLayout(new GridLayout(1,2, 10, 0));
		ch.add("서울");
		ch.add("경기");
		ch.add("강원");
		pSouth.add(ch);
		bExit.setFont(f);
		pSouth.add(bExit);
		
		setLayout(new BorderLayout(0, 10));
		add(pNorth, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
				
		//this.setSize(300, 400);
		//setLocation(300, 200);
		setBounds(300, 200, 300, 500);
		//setTitle("디자인 공부중입니다");
		//기왕이면 배치부의 마지막에서 setVisible을 할것
		this.setVisible(true);
	}
	//
	
	public static void main(String[] args) {
		new DesignTest();
	}
}
