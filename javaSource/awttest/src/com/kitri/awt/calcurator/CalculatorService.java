package com.kitri.awt.calcurator;

import java.awt.Label;

public class CalculatorService {

	CalculatorController calculatorController;
	Calculator calculator;
	StringBuffer inputData;
	String operator;
	double number1, number2;
	
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
		inputData = new StringBuffer();
		operator = null;
		number1 = Double.parseDouble(calculator.lNum.getText());
	}

	public void exit() {
		//종료버튼 눌렸을 시 작동
		System.exit(0);
	}

	public void pressDigit(String label) {
		//숫자버튼 눌렸을 시 작동	
		if(operator != null) {
			if(operator.equals("=")) {
			//마지막 연산자가 =인데 숫자가 입력들어오면 다시 처음부터
				clear();
			}
			if( !isNumber(inputData.charAt(0)) ) {
				//연산자 이후 첫숫자라면
				inputData.deleteCharAt(0);
			}
		}
		if( inputData.length() == 1 && inputData.charAt(0) == '0' && label.equals("0")) {
			//연속으로 0이 들어왔을때
			return;
		}else if( inputData.length() == 1 && inputData.charAt(0) == '0' ){
			//
			inputData.delete(0, 1);
		}
		inputData.append(label);
		calculator.lNum.setText(inputData.toString());
	}

	public void pressOperator(String label) {
		//연산자 눌렸을 시
		//inputData 확인
		if(inputData.length() == 0) {
			//inputData가 없는데 연산자가 눌리면 계산할 필욘 없음
			
		} else {
			//inputData가 있다.
			if( !isNumber(inputData.charAt(0))) {
				//연속해서 연산자가 눌림
				//계산할 필요는 없다.
			}else {
				//연속해서 연산자가 눌린게 아님
				if(operator == null) {
					//첫 연산자
					number1 = Double.parseDouble(inputData.toString());
				} else {
					number2 = Double.parseDouble(inputData.toString());
					calculate();
				}
			}
		}
		operator = label;
		calculator.lOper.setText(label);
		inputData.delete(0, inputData.length());
		inputData.append(operator);
		return;
	}
	
	public void calculate(){
		System.out.println(number1 + "  "+ operator + "  " + number2);
		switch(operator) {
		case "+":
			number1 = number1 + number2;
			break;
		case "-" :
			number1 = number1 - number2;
			break;
		case "*":
			number1 = number1 * number2;
			break;
		case "/":
			if(number2 == 0) {
				clear();
				calculator.lNum.setText("0으로 나눌 수 없습니다.");
				return;
			} else {
				number1 = number1 / number2;
			}
			break;
		case "=":
			//아무것도 안함
			break;
		}
		System.out.println("결과 : " + number1);
		writelNumber(number1);
	}

	public void clear() {
		calculator.lNum.setText("");
		calculator.lOper.setText("");
		number1 = 0;
		number2 = 0;
		operator = null;
		inputData.delete(0, inputData.length());
	}
	
	private boolean isNumber(char ch) {
		int number = ch - 48;
		if(number  < 0 || number > 9)
			return false;
		return true;
	}
	
	private void writelNumber(double number) {
		Label label = calculator.lNum;
		System.out.println(Math.round(number) + "   " + number);
		if(number == Math.round(number)) {
			label.setText(String.valueOf( (int)number ));
		} else {
			label.setText(String.valueOf(number));
		}
	}
	

}
