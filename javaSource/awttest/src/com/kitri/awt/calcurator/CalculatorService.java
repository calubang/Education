package com.kitri.awt.calcurator;

import java.awt.*;

public class CalculatorService {

	CalculatorController calculatorController;
	Calculator calculator;
	//���ڰ� ���ö����� �����ϴ� buffer
	StringBuffer inputData;
	//�Էµ� �����ڸ� ����
	String operator;
	//���� �����
	double result;
	
	public CalculatorService(CalculatorController calculatorController) {
		//�ʱⰪ ����
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
		operator = "";
		inputData = new StringBuffer(calculator.lNum.getText());
		result = Double.parseDouble(calculator.lNum.getText());
	}

	public void exit() {
		//�����ư ������ �� �۵�
		System.exit(0);
	}

	public void pressDigit(String label) {
		//���ڹ�ư ������ �� �۵�	
		//������ �����ڰ� = �ε� ���ڸ� �Է��ϸ� �ٽ� ó������ ����
		if(operator.equals("=")) {
			clear();
		}
		
		//ù���ڰ� 0�ΰ��
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
		
		//������ ���� ù���ڶ��
		if( !isNumber(inputData.charAt(0)) ) {
			inputData.deleteCharAt(0);
		}	
		
		inputData.append(label);
		calculator.lNum.setText(inputData.toString());
	}

	public void pressOperator(String label) {
		//������ ������ ��
		//�ֱ� �Է��� ���ڿ����� Ȯ��
		if(isNumber(inputData.charAt(0))) {
			if(operator.equals("")) {
				//ù ������
				result = Double.parseDouble(inputData.toString());
			} else {
				calculate();
			}
		}else {
			//�����ؼ� �����ڰ� ����
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
				calculator.lNum.setText("0���� ���� �� �����ϴ�.");
				return;
			} else {
				result /= inputDouble;
			}
			break;
		case "=":
			//�ƹ��͵� ����
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
