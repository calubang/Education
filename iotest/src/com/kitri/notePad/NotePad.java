package com.kitri.notePad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class NotePad extends JFrame {

	private JPanel contentPane;
	private NotePadController controller;
	public FileDialog fileDialogReSave;
	public FileDialog fileDialogOpen;
	public JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePad frame = new NotePad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NotePad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uD30C\uC77C");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewFile = new JMenuItem("\uC0C8\uB85C \uB9CC\uB4E4\uAE30");
		mnNewMenu.add(mntmNewFile);
		
		JMenuItem mntmOpen = new JMenuItem("\uC5F4\uAE30");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("\uC800\uC7A5");
		mnNewMenu.add(mntmSave);
		
		mnNewMenu.addSeparator();
		
		JMenuItem mntmExit = new JMenuItem("\uB05D\uB0B4\uAE30");
		mnNewMenu.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		panel.add(textArea);
		
		//다른이름으로 저장
		fileDialogReSave = new FileDialog(this, "다른 이름으로 저장", FileDialog.SAVE);
		
		//열기
		fileDialogOpen = new FileDialog(this, "열기", FileDialog.LOAD);
		
		//리스너 등록
		controller = new NotePadController(this);
		
		mntmOpen.addActionListener(controller);
		mnNewMenu.addActionListener(controller);
		mntmExit.addActionListener(controller);
		mntmNewFile.addActionListener(controller);
		mntmSave.addActionListener(controller);
		
	}
	
}
