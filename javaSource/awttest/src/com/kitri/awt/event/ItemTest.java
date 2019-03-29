package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame {
	
	//선언부
	String mealTime[] = {"아침", "점심", "저녁"};
	String fruit[] = {"사과", "바나나", "딸기"};
	Checkbox cbMeal[];
	Checkbox cbFruit[];
	
	//panel
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	//pN
	CheckboxGroup cbg1 = new CheckboxGroup();
	
	//pC
	TextArea ta = new TextArea();
	
	//ps
	Choice ch = new Choice();
	Button bExit = new Button("종료");
	
	//event
	ItemLogic itemLogic;
	
	
	//구성
	public ItemTest() {
		super("ItemTest 입니당");
		//pN 구성
		pN.setLayout(new GridLayout(2,3));
		
		cbMeal = new Checkbox[mealTime.length];
		cbFruit = new Checkbox[fruit.length];
		
		int len = mealTime.length;
		for(int i = 0; i<len ; i++) {
			cbMeal[i] = new Checkbox(mealTime[i], cbg1, false);
			pN.add(cbMeal[i]);
			ch.add(mealTime[i]);
		}
		
		len = fruit.length;
		for(int i = 0 ; i<len ; i++) {
			cbFruit[i] = new Checkbox(fruit[i]);
			if(fruit[i].equals("사과")) 
				cbFruit[i].setState(true);
			else
				cbFruit[i].setState(false);
			pN.add(cbFruit[i]);
		}
		
		//pS구성
		pS.setLayout(new BorderLayout());
		
		pS.add(ch, BorderLayout.CENTER);
		pS.add(bExit, BorderLayout.EAST);
		
		add(pN, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);
		
		setBounds(300, 200, 300, 500);
		this.setVisible(true);
		
		itemLogic = new ItemLogic(this); 
		
		//event 등록
		bExit.addActionListener(itemLogic);
		len = cbFruit.length;
		for (int i = 0; i < len; i++) {
			cbFruit[i].addItemListener(itemLogic);
		}
		
		len = cbMeal.length;
		for (int i = 0; i < len; i++) {
			cbMeal[i].addItemListener(itemLogic);
		}
		len = cbFruit.length;
		for (int i = 0; i < len; i++) {
			cbFruit[i].addItemListener(itemLogic);
		}
		ch.addItemListener(itemLogic);
		
		WindowAdapter wa = new WindowAdapter() {
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(wa);
	}
	
	public static void main(String[] args) {
		new ItemTest();
	}

	
}
