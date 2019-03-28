package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BaseBall extends Frame{
	
	//�����
	String bStr[] = {"������", "�����", "����", "���ڻ�", "����"};
	
	//�г�
	Panel pCenter = new Panel();
	Panel pTF = new Panel(); 
	Panel pEast = new Panel();
	
	//pc
	TextArea ta = new TextArea();
	Label l = new Label("����", Label.CENTER);
	TextField tf = new TextField();
	
	//pe
	
	public BaseBall() {
		
		//pta
		pTF.setLayout(new BorderLayout());
		pTF.add(tf, BorderLayout.CENTER);
		pTF.add(l, BorderLayout.WEST);
		
		//pc
		pCenter.setLayout(new BorderLayout(0,10));
		pCenter.add(ta, BorderLayout.CENTER);
		pCenter.add(pTF, BorderLayout.SOUTH);
		
		//pe
		int len = bStr.length;
		Font f = new Font("Verdana", Font.PLAIN, 13);
		
		pEast.setLayout(new GridLayout(len, 0, 0, 10));
		for (int i = 0; i < len; i++) {
			Button button = new Button(bStr[i]);
			button.setFont(f);
			pEast.add(button);
		}
		
		setLayout(new BorderLayout(10,0));
		add(pCenter, BorderLayout.CENTER);
		add(pEast, BorderLayout.EAST);
		
		setBounds(300, 200, 500, 400);
		this.setVisible(true);
	
		WindowAdapter wa = new WindowAdapter() {
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(wa);
	}
	
	
	public static void main(String[] args) {
		new BaseBall();
	}
}
