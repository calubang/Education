package com.kitri.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	public JButton b1;
	public JButton b2;

	JPanel panel = new JPanel();
	CardLayout cardLayout = new CardLayout();
	View1 view1 = new View1();
	View2 view2 = new View2();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(12, 68, 637, 361);
		panel.setLayout(cardLayout);
		panel.add("view1", view1);
		panel.add("view2", view2);
		cardLayout.show(panel, "view2");
		
		contentPane.add(panel);
		
		
		b1 = new JButton("\uD654\uBA741");
		b1.setBounds(12, 10, 155, 48);
		contentPane.add(b1);
		
		b2 = new JButton("\uD654\uBA742");
		b2.setBounds(181, 10, 155, 48);
		contentPane.add(b2);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == b1){
			cardLayout.show(panel, "view1");
		} else{
			cardLayout.show(panel, "view2");
		}
		
	}

}
