package com.kitri.notePad;

import java.awt.FileDialog;
import java.io.*;

public class NotePadService {

	private NotePadController notePadController;
	private NotePad notePad;
	
	public NotePadService(NotePadController notePadController) {
		this.notePadController = notePadController;
		this.notePad = notePadController.notePad;
	}

	public void save() {
		FileDialog fileDialogReSave = notePad.fileDialogReSave;
		fileDialogReSave.setVisible(true);
		File file[] = fileDialogReSave.getFiles();
		//String filePath = fileDialogReSave.getDirectory() + fileDialogReSave.getFile();
		
		FileWriter fileWriter = null;
		
		if(file.length == 0) {
			return;
		}
		
		try {
			System.out.println(file[0]);
			fileWriter = new FileWriter(file[0]);
			String data = notePad.textArea.getText();
			fileWriter.write(data.replace("\n", "\r\n"));
		
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

	public void open() {
		clear();
		
		FileDialog fileDialogOpen = notePad.fileDialogOpen;
		fileDialogOpen.setVisible(true);
		File file[] = fileDialogOpen.getFiles();
		
		BufferedReader in = null;
		
		if(file.length == 0) {
			return;
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file[0])));
			String buffer = null;
			while( (buffer = in.readLine()) != null) {
				notePad.textArea.append(buffer + "\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void clear() {
		notePad.textArea.removeAll();
		
	}

}
