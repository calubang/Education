package com.kitri.chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField newname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReName frame = new ReName();
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
	public ReName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 249);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 191, 216));
		panel.setBorder(new LineBorder(Color.GRAY));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 191, 216));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Name : ");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 114, 46);
		panel_1.add(lblNewLabel);
		
		JLabel oldname = new JLabel("oldname");
		oldname.setFont(new Font("Verdana", Font.BOLD, 14));
		oldname.setHorizontalAlignment(SwingConstants.CENTER);
		oldname.setBounds(138, 10, 269, 46);
		panel_1.add(oldname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 191, 216));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewName = new JLabel("New Name : ");
		lblNewName.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewName.setBounds(12, 10, 114, 46);
		panel_2.add(lblNewName);
		
		newname = new JTextField();
		newname.setFont(new Font("Verdana", Font.BOLD, 14));
		newname.setBounds(138, 10, 269, 46);
		panel_2.add(newname);
		newname.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(216, 191, 216));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton ok = new JButton("\uBCC0\uACBD");
		ok.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		ok.setBounds(109, 10, 97, 46);
		panel_3.add(ok);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		cancel.setBounds(224, 10, 97, 46);
		panel_3.add(cancel);
	}

}
