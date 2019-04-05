package com.kitri.chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Paper extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
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
	public Paper() {
		setResizable(false);
		this.setTitle("쪽지 보내기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBorder(new LineBorder(Color.GRAY));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(12, 10, 404, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 55, 50);
		panel_1.add(lblNewLabel);
		
		JLabel from = new JLabel("from");
		from.setOpaque(true);
		from.setFont(new Font("Verdana", Font.BOLD, 14));
		from.setBackground(Color.ORANGE);
		//label.setForeground(Color.BLACK);
		from.setHorizontalAlignment(SwingConstants.CENTER);
		from.setBounds(67, 0, 127, 50);
		panel_1.add(from);
		
		JLabel to = new JLabel("New label");
		to.setOpaque(true);
		to.setFont(new Font("Verdana", Font.BOLD, 14));
		to.setBackground(Color.ORANGE);
		//label_1.setForeground(Color.BLACK);
		to.setHorizontalAlignment(SwingConstants.CENTER);
		to.setBounds(277, 0, 127, 50);
		panel_1.add(to);
		
		
		JLabel lblTo = new JLabel("T o : ");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(210, 0, 55, 50);
		panel_1.add(lblTo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(12, 70, 404, 251);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTextArea letter = new JTextArea();
		panel_2.add(letter, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.YELLOW);
		panel_3.setBounds(12, 331, 404, 50);
		panel.add(panel_3);
		
		JButton send = new JButton("\uBCF4\uB0B4\uAE30");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_3.add(panel_4);
		panel_3.add(send);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		panel_3.add(cancel);
	}

}
