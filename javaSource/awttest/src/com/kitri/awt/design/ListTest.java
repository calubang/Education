package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {
	
	String buttonStr[] = {"¢·", "¢¸", "¢¹", "¢º"};
	//¼±¾ðºÎ
	Panel pRight = new Panel();
	Panel pLeft = new Panel();
	Panel pCenter = new Panel();
	
	//pL
	TextField tfL = new TextField();
	List listL = new List();
	
	//pC
	
	//pR
	List listR = new List();
	TextField tfR = new TextField();
	
	
	public ListTest() {
		//pl
		pLeft.setLayout(new BorderLayout(0,10));
		pLeft.add(listL, BorderLayout.CENTER);
		pLeft.add(tfL, BorderLayout.SOUTH);
		

		int len = buttonStr.length;
		//pCenter.setLayout(new GridLayout(len+6, 1, 10, 10));
		GridBagLayout gbl = new GridBagLayout();
		pCenter.setLayout(gbl);
		//gbl.columnWeights = new double[]{1,1,1};
		//gbl.rowWeights = new double[] {1, 1, 1, 1, 1, 1, 1, 1};
		
		
		for (int i = 0; i < len; i++) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 1;
			gbc.gridy = 2+i;
			Button button = new Button(buttonStr[i]);
			pCenter.add(button, gbc);
		}
		
		//pr
		pRight.setLayout(new BorderLayout(0, 10));
		pRight.add(listR, BorderLayout.CENTER);
		pRight.add(tfR, BorderLayout.SOUTH);
		
		
		setLayout(new GridLayout(1, 3, 10, 0));
		//setLayout(new FlowLayout());
		
		
		add(pLeft);
		add(pCenter);
		add(pRight);
		
		
		
		setBounds(300, 200, 500, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListTest();
	}
}
