package com.kitri.awt.design;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemTest extends Frame{
	
	//선언부
	String mealTime[] = {"아침", "점심", "저녁"};
	String fruit[] = {"사과", "바나나", "딸기"};
	
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
	
	//구성
	public ItemTest() {
		//pN 구성
		pN.setLayout(new GridLayout(2,3));
		
		int len = mealTime.length;
		for(int i = 0; i<len ; i++) {
			pN.add(new Checkbox(mealTime[i], cbg1, false));
			ch.add(mealTime[i]);
		}
		
		len = fruit.length;
		for(int i = 0 ; i<len ; i++) {
			if(fruit[i].equals("사과")) 
				pN.add(new Checkbox(fruit[i], true));
			else
				pN.add(new Checkbox(fruit[i], false));
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
