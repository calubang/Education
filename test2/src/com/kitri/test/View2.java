package com.kitri.test;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public View2() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 38, 159, 172);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText("\uC785\uB825\uD558\uC138\uC694");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(193, 38, 143, 172);
		add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JLabel label = new JLabel("\uC785\uB825");
		label.setBounds(193, 220, 24, 41);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 220, 107, 41);
		add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 27, 181, 242);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825");
		lblNewLabel.setBounds(12, 195, 31, 37);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(55, 195, 114, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBounds(348, 42, 74, 165);
		add(list_1);

	}
}
