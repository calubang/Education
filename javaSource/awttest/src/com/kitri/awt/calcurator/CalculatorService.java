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
		//�����ư ������ �� �۵�
		System.exit(0);
	}

	public void pressDigit(String label) {
		//���ڹ�ư ������ �� �۵�	
		if(operator != null) {
			if(operator.equals("=")) {
			//������ �����ڰ� =�ε� ���ڰ� �Էµ����� �ٽ� ó������
				clear();
			}
			if( !isNumber(inputData.charAt(0)) ) {
				//������ ���� ù���ڶ��
				inputData.deleteCharAt(0);
			}
		}
		if( inputData.length() == 1 && inputData.charAt(0) == '0' && label.equals("0")) {
			//�������� 0�� ��������
			return;
		}else if( inputData.length() == 1 && inputData.charAt(0) == '0' ){
			//
			inputData.delete(0, 1);
		}
		inputData.append(label);
		calculator.lNum.setText(inputData.toString());
	}

	public void pressOperator(String label) {
		//������ ������ ��
		//inputData Ȯ��
		if(inputData.length() == 0) {
			//inputData�� ���µ� �����ڰ� ������ ����� �ʿ� ����
			
		} else {
			//inputData�� �ִ�.
			if( !isNumber(inputData.charAt(0))) {
				//�����ؼ� �����ڰ� ����
				//����� �ʿ�� ����.
			}else {
				//�����ؼ� �����ڰ� ������ �ƴ�
				if(operator == null) {
					//ù ������
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
				calculator.lNum.setText("0���� ���� �� �����ϴ�.");
				return;
			} else {
				number1 = number1 / number2;
			}
			break;
		case "=":
			//�ƹ��͵� ����
			break;
		}
		System.out.println("��� : " + number1);
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
