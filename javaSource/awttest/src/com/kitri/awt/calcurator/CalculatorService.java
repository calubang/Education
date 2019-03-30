package com.kitri.awt.calcurator;

import java.awt.*;
// : buffer �� �ԷµȰ͵��� ����, ������� result�� ����
// : �����ȣ�� ������ �׵��� ���� data �� ����ȭ �� ���, buffer�� ���� �����ȣ�� ����
// : ù �Է¼��ڰ� 0�ΰ�� ��� 0ó��, ���� ���ڰ� ������ 0�� ����
// : �������� ������ �����ȣ�� ������ �����ȣ�� �������� �Ѵ�.
// : ������0 ó���� ���߸� ���� enable �ϰ� �ʱ�ȭ��ư�� ����д�
public class CalculatorService {

	CalculatorController calculatorController;
	Calculator calculator;
	Label lNum, lOper;
	StringBuffer inputData;
	String operator;
	double result;
	
	//������� ���
	private final String DIVISION_BY_ZERO = "-1";
	
	//������
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
		lOper = calculator.lOper;
		lNum = calculator.lNum;
		
		operator = "";
		inputData = new StringBuffer(lNum.getText());
		result = Double.parseDouble(lNum.getText());
	}
	
	//�����ư ������ �� �۵�
	public void exit() {
		System.exit(0);
	}
	
	//Ŭ����
	public void clear() {
		// 0���� �������� or �ùٸ��� ���� ����� ����Ǿ��� ��
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
	
	//���ڹ�ư
	public void pressDigit(String label) {
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
				lNum.setText(inputData.toString());
				return;
			}
		}
		
		//������ ���� ù���ڶ��
		if( !isNumber(inputData.charAt(0)) ) {
			inputData.deleteCharAt(0);
		}	
		
		inputData.append(label);
		lNum.setText(inputData.toString());
	}
	
	//�����ڹ�ư
	public void pressOperator(String label) {
		//�ֱ� �Է��� ���ڿ����� Ȯ��
		if(isNumber(inputData.charAt(0))) {
			if(operator.equals("")) {
				//ù ������
				result = Double.parseDouble(inputData.toString());
			} else {
				if( !calculate() )
					//�ùٸ��� ���� ����� ����
					return;
			}
		}else {
			//�����ؼ� �����ڰ� ����
		}
		operator = label;
		lOper.setText(operator);
		inputData.replace(0, inputData.length(), operator);
	}
	
	//���
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
			//�ƹ��͵� ����
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
			lNum.setText("0���� ���� �� �����ϴ�.");
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
	
	//����üũ
	private boolean isNumber(char ch) {
		int number = ch - 48;
		if(number  < 0 || number > 9)
			return false;
		return true;
	}
	
	//.0 ó��
	private void writelNum(double number) {
		if(number == Math.round(number)) {
			lNum.setText(String.valueOf( (int)number ));
		} else {
			lNum.setText(String.valueOf(number));
		}
	}
}
