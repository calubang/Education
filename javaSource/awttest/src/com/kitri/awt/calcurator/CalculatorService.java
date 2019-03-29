package com.kitri.awt.calcurator;

import java.awt.*;

public class CalculatorService {

	CalculatorController calculatorController;
	Calculator calculator;
	//숫자가 들어올때마다 저장하는 buffer
	StringBuffer inputData;
	//입력된 연산자를 저장
	String operator;
	//실제 계산결과
	double result;
	
	public CalculatorService(CalculatorController calculatorController) {
		//초기값 설정
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
		operator = "";
		inputData = new StringBuffer(calculator.lNum.getText());
		result = Double.parseDouble(calculator.lNum.getText());
	}

	public void exit() {
		//종료버튼 눌렸을 시 작동
		System.exit(0);
	}

	public void pressDigit(String label) {
		//숫자버튼 눌렸을 시 작동	
		//마지막 연산자가 = 인데 숫자를 입력하면 다시 처음부터 시작
		if(operator.equals("=")) {
			clear();
		}
		
		//첫글자가 0인경우
		if(inputData.charAt(0) == '0') {
			if(label.equals("0")) {
				return;
			}
			else {
				inputData.replace(0, inputData.length(), label);
				calculator.lNum.setText(inputData.toString());
				return;
			}
		}
		
		//연산자 이후 첫숫자라면
		if( !isNumber(inputData.charAt(0)) ) {
			inputData.deleteCharAt(0);
		}	
		
		inputData.append(label);
		calculator.lNum.setText(inputData.toString());
	}

	public void pressOperator(String label) {
		//연산자 눌렸을 시
		//최근 입력이 숫자였는지 확인
		if(isNumber(inputData.charAt(0))) {
			if(operator.equals("")) {
				//첫 연산자
				result = Double.parseDouble(inputData.toString());
			} else {
				calculate();
			}
		}else {
			//연속해서 연산자가 눌림
		}
		operator = label;
		calculator.lOper.setText(operator);
		inputData.delete(0, inputData.length());
		inputData.append(operator);
	}
	
	public void calculate(){
		if(inputData.length() == 0) {
			writelNum(result);
			return;
		}
		double inputDouble = Double.parseDouble(inputData.toString());
		
		switch(operator) {
		case "+":
			result += inputDouble;
			break;
		case "-" :
			result -= inputDouble;
			break;
		case "*":
			result *= inputDouble;
			break;
		case "/":
			if(inputDouble == 0) {
				clear();
				calculator.lNum.setText("0으로 나눌 수 없습니다.");
				return;
			} else {
				result /= inputDouble;
			}
			break;
		case "=":
			//아무것도 안함
			break;
		}
		writelNum(result);
	}

	public void clear() {
		operator = "";
		calculator.lOper.setText("");
		inputData.replace(0, inputData.length(), "0");
		result = 0;
		writelNum(result);
	}
	
	private boolean isNumber(char ch) {
		int number = ch - 48;
		if(number  < 0 || number > 9)
			return false;
		return true;
	}
	
	private void writelNum(double number) {
		Label label = calculator.lNum;
		if(number == Math.round(number)) {
			label.setText(String.valueOf( (int)number ));
		} else {
			label.setText(String.valueOf(number));
		}
	}
}
