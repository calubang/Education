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
		case "새로 만들기":
			notePadService.clear();
			break;
		case "저장":
			notePadService.save();
			break;
		case "열기":
			notePadService.open();
			break;
		case "끝내기":
			break;
		default:
			break;
		}
	}

}
