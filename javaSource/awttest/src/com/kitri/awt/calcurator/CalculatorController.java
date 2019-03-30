package com.kitri.awt.calcurator;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener{
	
	Calculator calculator;
	CalculatorService calcalatorService;
	
	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
		calcalatorService = new CalculatorService(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button button = (Button)e.getSource();		
		String label = button.getLabel();
		
		if(label.charAt(0) >= '0' && label.charAt(0) <= '9') {
			//숫자
			calcalatorService.pressDigit(label);
		} else if (label.equals("종료")) {
			//종료
			calcalatorService.exit();
		} else if(label.equals("C")) {
			//클리어
			calcalatorService.clear();
		} else {
			//연산자
			calcalatorService.pressOperator(label);
		}
	}
}
