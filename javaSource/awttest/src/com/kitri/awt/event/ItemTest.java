package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame implements ItemListener, ActionListener{
	
	//�����
	String mealTime[] = {"��ħ", "����", "����"};
	String fruit[] = {"���", "�ٳ���", "����"};
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
	Button bExit = new Button("����");
	
	//����
	public ItemTest() {
		super("ItemTest �Դϴ�");
		//pN ����
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
			if(fruit[i].equals("���")) 
				cbFruit[i].setState(true);
			else
				cbFruit[i].setState(false);
			pN.add(cbFruit[i]);
		}
		
		//pS����
		pS.setLayout(new BorderLayout());
		
		pS.add(ch, BorderLayout.CENTER);
		pS.add(bExit, BorderLayout.EAST);
		
		add(pN, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(pS, BorderLayout.SOUTH);
		
		setBounds(300, 200, 300, 500);
		this.setVisible(true);
		
		//event ���
		bExit.addActionListener(this);
		len = cbFruit.length;
		for (int i = 0; i < len; i++) {
			cbFruit[i].addItemListener(this);
		}
		
		len = cbMeal.length;
		for (int i = 0; i < len; i++) {
			cbMeal[i].addItemListener(this);
		}
		len = cbFruit.length;
		for (int i = 0; i < len; i++) {
			cbFruit[i].addItemListener(this);
		}
		ch.addItemListener(this);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if( e.getSource() == ch ) {
			cbg1.setSelectedCheckbox(cbMeal[ch.getSelectedIndex()]);
		}
		
		Checkbox cbSelect = cbg1.getSelectedCheckbox();
		String selectStr = cbSelect.getLabel();
		ta.setText("---" + selectStr + "---");
		int len = cbFruit.length;
		for (int i = 0; i < len; i++) {
			ta.append("\n" + (i+1) + ". " + fruit[i] + " : " + (cbFruit[i].getState() ? "�Ծ���" : "�ȸԾ���") );
		}

		ch.select(selectStr);
	}
}
