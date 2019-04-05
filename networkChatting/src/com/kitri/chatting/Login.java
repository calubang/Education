package com.kitri.chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ipTF;
	private JTextField nameTF;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setResizable(false);
		this.setTitle("Login!!!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pMain = new JPanel();
		pMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		pMain.setBounds(5, 5, 424, 222);
		contentPane.add(pMain);
		pMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 154, 400, 58);
		pMain.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(95, 10, 100, 38);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(221, 10, 100, 38);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 400, 59);
		pMain.add(panel_1);
		panel_1.setLayout(null);
		
		ipTF = new JTextField();
		ipTF.setBounds(94, 0, 306, 59);
		panel_1.add(ipTF);
		ipTF.setColumns(10);
		
		JLabel lblIP = new JLabel("I       P    : ");
		lblIP.setHorizontalAlignment(SwingConstants.CENTER);
		lblIP.setBounds(0, 0, 92, 59);
		panel_1.add(lblIP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 79, 400, 58);
		pMain.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB300\uD654\uBA85    :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 92, 59);
		panel_2.add(lblNewLabel);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(94, 0, 306, 59);
		panel_2.add(nameTF);
	}
}
