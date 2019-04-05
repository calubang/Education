package foodCourttest;

import javax.swing.*;

public class FButton extends JButton{
	
	public FButton() {
		super();
	}
	
	public FButton(String label) {
		super(label);
	}

	public FButton(Action a) {
		super(a);
	}

	public FButton(Icon icon) {
		super(icon);
	}

	public FButton(String text, Icon icon) {
		super(text, icon);
	}
	
	
	
}
