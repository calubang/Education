package com.kitri.notePad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class NotePadController implements ActionListener{

	public NotePad notePad;
	public NotePadService notePadService;
	
	public NotePadController(NotePad notePad){
		this.notePad = notePad;
		notePadService = new NotePadService(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem)e.getSource();
		String text = item.getText();
		switch (text) {

		default:
			break;
		}
	}

}
