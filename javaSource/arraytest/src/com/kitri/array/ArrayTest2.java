package com.kitri.array;

public class ArrayTest2 {
	
	public static void main(String[] args) {
		
		Car[] car = new Car[6];
		car[0] = new Car("�Ÿ1", "������1", "����1");
		car[1] = new Car("�Ÿ2", "������2", "����2");
		car[2] = new Car("�Ÿ3", "������3", "����3");
		car[3] = new Car("�Ÿ4", "������4", "����4");
		car[4] = new Car("�Ͼ��", "��ѱ�", "��������");
		car[5] = new Car("��Ÿ��", "ȸ��", "cu");
		
		System.out.println(car[0].getCarName());
		
		for(int i = 0 ; i<car.length ; i++) {
			System.out.println("[" + i + "] : " + car[i]);
		}
		
		
		String name = "�Ͼ��";
		name = "QM5";
		Car temp = null;
		int number = 0;
		
		for(int i = 0 ; i < car.length ; i++) {
			if(car[i].getCarName().equals(name) ) {
				temp = car[i];
				number = i+1;
				break;
			}
		}
		
		if(temp != null) {
			System.out.println(temp.getColor() +"�� " 
					+ temp.getCarName() + "(" + temp.getMaker() +  ")�� " + number + "��°�� �ֽ��ϴ�." );
		} else{
			System.out.println(name + "�� �����ϴ�.");
		}
	}
}
