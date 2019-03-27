package com.kitri.awt.design;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

// 1. Frame ���
// 2. ����ο� �ʿ��� ��ü ����(�����ڿ��� �ص� ����)
// 3. ��ġ�ο��� design (component ��ġ)
//     3-1 ��ġ���� �������� ������ setVisible
// 4. �۾��� ������ -> ū��
import java.awt.*;

public class DesignTest extends Frame{
	//�����
	Panel pNorth = new Panel();
	Panel pSouth = new Panel();
	
	Label l = new Label("�Է�", Label.CENTER);
	TextField tf =  new TextField();
	Button bSend = new Button("����");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button bExit = new Button("����");
	
	//��ġ��
	public DesignTest() {
		super("������ �׽�Ʈ�Դϴ�.");
		
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
		ch.add("����");
		ch.add("���");
		ch.add("����");
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
		//setTitle("������ �������Դϴ�");
		//����̸� ��ġ���� ���������� setVisible�� �Ұ�
		this.setVisible(true);
	}
	//
	
	public static void main(String[] args) {
		new DesignTest();
	}
}
