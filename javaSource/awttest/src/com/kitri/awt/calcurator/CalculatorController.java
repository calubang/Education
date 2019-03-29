package com.kitri.awt.calcurator;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener{
	
	Calculator calculator;
	CalculatorService calcalatorService;
	//String bStr[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/"};
	
	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
		calcalatorService = new CalculatorService(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button button = (Button)e.getSource();		
		String label = button.getLabel();
		//String labelArray[] = calculator.bStr;
		if(label.charAt(0) >= '0' && label.charAt(0) <= '9') {
			//
			calcalatorService.pressDigit(label);
		
		} else if (label.equals("종료")) {
			//종료
			calcalatorService.exit();
		
		} else if(label.equals("C")) {
			calcalatorService.clear();
		} else {
			// 일반 연산자들
			calcalatorService.pressOperator(label);
		}
	}
}
