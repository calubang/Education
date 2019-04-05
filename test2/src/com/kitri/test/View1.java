package com.kitri.test;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class View1 extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public View1() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 136, 235, 154);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(12, 10, 52, 36);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(75, 11, 148, 36);
		panel.add(textField);
		textField.setToolTipText("\uC5EC\uAE30\uB294 \uC544\uC774\uB514");
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(12, 56, 52, 36);
		panel.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(75, 57, 148, 36);
		panel.add(passwordField);
		passwordField.setToolTipText("\uC5EC\uAE30\uB294 \uBE44\uBC00\uBC88\uD638");
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(41, 102, 85, 43);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.setBounds(138, 102, 85, 43);
		panel.add(button);

	}
}
