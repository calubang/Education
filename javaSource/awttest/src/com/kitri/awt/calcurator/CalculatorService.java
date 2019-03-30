package com.kitri.awt.calcurator;

import java.awt.*;
// : buffer 에 입력된것들을 저장, 계산결과는 result에 저장
// : 연산기호가 들어오면 그동안 들어온 data 는 숫자화 후 계산, buffer는 비우고 연산기호로 변경
// : 첫 입력숫자가 0인경우 계속 0처리, 이후 숫자가 들어오면 0은 삭제
// : 연속으로 들어오는 연산기호는 마지막 연산기호를 기준으로 한다.
// : 나누기0 처리는 단추를 전부 enable 하고 초기화버튼만 열어둔다
public class CalculatorService {

	CalculatorController calculatorController;
	Calculator calculator;
	Label lNum, lOper;
	StringBuffer inputData;
	String operator;
	double result;
	
	//에러모드 상수
	private final String DIVISION_BY_ZERO = "-1";
	
	//생성자
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
		lOper = calculator.lOper;
		lNum = calculator.lNum;
		
		operator = "";
		inputData = new StringBuffer(lNum.getText());
		result = Double.parseDouble(lNum.getText());
	}
	
	//종료버튼 눌렸을 시 작동
	public void exit() {
		System.exit(0);
	}
	
	//클리어
	public void clear() {
		// 0으로 나눴을때 or 올바르지 않은 계산이 수행되었을 시
		if(operator.equals(DIVISION_BY_ZERO)) {
			for(int i=0 ; i< calculator.buttonAmount ; i++) {
				calculator.bDigit[i].setEnabled(true);
			}
		}
		operator = "";
		lOper.setText("");
		inputData.replace(0, inputData.length(), "0");
		result = 0;
		writelNum(result);
	}
	
	//숫자버튼
	public void pressDigit(String label) {
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
				lNum.setText(inputData.toString());
				return;
			}
		}
		
		//연산자 이후 첫숫자라면
		if( !isNumber(inputData.charAt(0)) ) {
			inputData.deleteCharAt(0);
		}	
		
		inputData.append(label);
		lNum.setText(inputData.toString());
	}
	
	//연산자버튼
	public void pressOperator(String label) {
		//최근 입력이 숫자였는지 확인
		if(isNumber(inputData.charAt(0))) {
			if(operator.equals("")) {
				//첫 연산자
				result = Double.parseDouble(inputData.toString());
			} else {
				if( !calculate() )
					//올바르지 않은 계산이 수행
					return;
			}
		}else {
			//연속해서 연산자가 눌림
		}
		operator = label;
		lOper.setText(operator);
		inputData.replace(0, inputData.length(), operator);
	}
	
	//계산
	private boolean calculate(){
		if(inputData.length() == 0) {
			writelNum(result);
			return true;
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
				errorMode(DIVISION_BY_ZERO);
				return false;
			} else {
				result /= inputDouble;
			}
			break;
		case "=":
			//아무것도 안함
			break;
		}
		writelNum(result);
		return true;
	}
	
	//ErrorMode
	private void errorMode(String error) {
		operator = error;
		
		switch (error) {
		case DIVISION_BY_ZERO:
			lNum.setText("0으로 나눌 수 없습니다.");
			for(int i=0 ; i< calculator.buttonAmount ; i++) {
				if( !calculator.bDigit[i].getLabel().equals("C")) {
					calculator.bDigit[i].setEnabled(false);
				}
			}
			break;
		default:
			break;
		}
	}
	
	//숫자체크
	private boolean isNumber(char ch) {
		int number = ch - 48;
		if(number  < 0 || number > 9)
			return false;
		return true;
	}
	
	//.0 처리
	private void writelNum(double number) {
		if(number == Math.round(number)) {
			lNum.setText(String.valueOf( (int)number ));
		} else {
			lNum.setText(String.valueOf(number));
		}
	}
}
