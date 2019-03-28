package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ListTest extends Frame implements ActionListener {
	
	String buttonStr[] = {"◁", "◀", "▷", "▶"};
	Button bArray[];
	
	//선언부
	Panel pRight = new Panel();
	Panel pLeft = new Panel();
	Panel pCenter = new Panel();
	
	//pL
	TextField tfL = new TextField();
	List listL = new List(10);
	
	//pC
	
	//pR
	List listR = new List(10, true);
	TextField tfR = new TextField();
	
	
	public ListTest() {
		super("ListTest 입니당");
		bArray = new Button[buttonStr.length];
		Font fList = new Font("Verdana", Font.BOLD, 15);
		//pl
		listL.setFont(fList);
		pLeft.setLayout(new BorderLayout(0,10));
		pLeft.add(listL, BorderLayout.CENTER);
		pLeft.add(tfL, BorderLayout.SOUTH);
		
		int len = buttonStr.length;
		pCenter.setLayout(new GridLayout(len+4, 1, 10, 10));
		Font f = new Font("Verdana", Font.PLAIN, 15);
		
		pCenter.add(new Panel());
		pCenter.add(new Panel());
		for (int i = 0; i < len; i++) {
			bArray[i] = new Button(buttonStr[i]);
			bArray[i].setFont(f);
			pCenter.add(bArray[i]);
		}
		
		//pr
		listR.setFont(fList);
		pRight.setLayout(new BorderLayout(0, 10));
		pRight.add(listR, BorderLayout.CENTER);
		pRight.add(tfR, BorderLayout.SOUTH);
		
		
		setLayout(new GridLayout(1, 3, 10, 0));
		
		add(pLeft);
		add(pCenter);
		add(pRight);
		
		setBounds(300, 200, 500, 500);
		this.setVisible(true);
		
		//event
		tfL.addActionListener(this);
		tfR.addActionListener(this);
		len = bArray.length;
		for (int i = 0; i < len; i++) {
			bArray[i].addActionListener(this);
		}
	
		WindowAdapter wa = new WindowAdapter() {
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(wa);
	
	}
	
	public static void main(String[] args) {
		new ListTest();
	}
	
	private void tfToList(TextField from, List to) {
		String text = from.getText();
		from.setText("");
		if(text.isEmpty()) {
			return;
		}
		to.add(text);
	}
	private void selectedMove(List from, List to) {
		int index = from.getSelectedIndex();
		String text = from.getSelectedItem();
		if(text == null) {
			return ;
		}
		to.add(text);
		from.remove(index);
	}
	private void allMove(List from, List to) {
		int len = from.getItemCount();
		
		if(len == 0)
			return ;
		
		for (int i = 0; i < len ; i++ ) {
			to.add(from.getItem(0));
			from.remove(0);
		}
	}
	private void mutipleSelectedMove(List from, List to) {
		int index[] = from.getSelectedIndexes();
		
		if(index == null) {
			return ;
		}
		int len = index.length;
		for (int i = 0; i < len; i++) {
			to.add(from.getItem(index[i]));
		}
		for (int i = 0; i < len ; i++) {
			from.remove(index[i]);
			if(i  < len - 1) {
				index[i+1] -= i+1;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == tfL) {
			tfToList(tfL, listL);
		} else if(obj == tfR) {
			tfToList(tfR, listR);
		} else if(obj == bArray[0]) {
			//<
			selectedMove(listR, listL);
		} else if(obj == bArray[1]) {
			// <<
			mutipleSelectedMove(listR, listL);
		} else if(obj == bArray[2]) {
			//>
			selectedMove(listL, listR);
		} else if(obj == bArray[3]) {
			// >>
			allMove(listL, listR);
		} else {
			
		}
	}
}
