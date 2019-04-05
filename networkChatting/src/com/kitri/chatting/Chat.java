package com.kitri.chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField globalsend;
	private JTextField whomsend;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Chat() {
		setResizable(false);
		this.setTitle("Αρ°ΕΏξ Γ€ΖΓ...*^^*");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 393, 409);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 393, 310);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTextArea area = new JTextArea();
		panel_2.add(area, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 320, 393, 89);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		globalsend = new JTextField();
		globalsend.setBounds(0, 0, 393, 40);
		panel_3.add(globalsend);
		globalsend.setColumns(10);
		
		whomsend = new JTextField();
		whomsend.setBounds(59, 49, 334, 40);
		panel_3.add(whomsend);
		whomsend.setColumns(10);
		
		JLabel whom = new JLabel("\uADD3\uC18D\uB9D0");
		whom.setHorizontalAlignment(SwingConstants.LEFT);
		whom.setBounds(0, 49, 47, 40);
		panel_3.add(whom);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(417, 10, 195, 409);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 260, 195, 149);
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 10, 5));
		
		JButton rename = new JButton("\uB300\uD654\uBA85\uBCC0\uACBD");
		panel_5.add(rename);
		
		JButton paper = new JButton("\uCABD\uC9C0\uBCF4\uB0B4\uAE30");
		panel_5.add(paper);
		
		JButton close = new JButton("\uB098\uAC00\uAE30");
		panel_5.add(close);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(0, 0, 195, 250);
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		panel_6.add(list, BorderLayout.CENTER);
		
		
	}
}
