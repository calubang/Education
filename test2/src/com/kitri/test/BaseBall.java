package com.kitri.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class BaseBall extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton font;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseBall frame = new BaseBall();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BaseBall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGg = new JLabel("\uC785\uB825");
		lblGg.setHorizontalAlignment(SwingConstants.CENTER);
		lblGg.setBounds(12, 515, 71, 94);
		contentPane.add(lblGg);
		
		textField = new JTextField();
		textField.setBounds(95, 514, 629, 95);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(736, 10, 248, 599);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 10));
		
		JButton newGame = new JButton("\uC0C8\uAC8C\uC784");
		newGame.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 248, 220), new Color(255, 218, 185)));
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(newGame);
		
		JButton clear = new JButton("\uC9C0\uC6B0\uAE30");
		panel.add(clear);
		
		JButton dap = new JButton("\uC815\uB2F5");
		panel.add(dap);
		
		font = new JButton("\uAE00\uC790\uC0C9");
		panel.add(font);
		
		JButton exit = new JButton("\uC885\uB8CC");
		panel.add(exit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 710, 495);
		contentPane.add(scrollPane);
		
		JTextArea txtrGg = new JTextArea();
		txtrGg.setText("gg");
		scrollPane.setViewportView(txtrGg);
	}
}
