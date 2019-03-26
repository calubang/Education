import java.util.*;

public class TaxiGuest {
	public static void main(String[] args) {
		
		Taxi t1 = new Taxi();
		System.out.println(t1.info());

		Taxi t2 = new Taxi("K5", "��ȫ��", "���");
		System.out.println(t2.info());

		int km = 20;
		System.out.println(t2.info() + "�� Ÿ�� ���𿡼� �������� " 
			+ km + "km�̵�!!!");
		int price = t2.calcPrice(km);
		System.out.println("��� : " + price + "��");
		System.out.println("���� ���� : " + t2.totalPrice + "��");

		km = 20;
		System.out.println(t2.info() + "�� Ÿ�� �������� ������� " 
			+ km + "km�̵�!!!");
		price = t2.calcPrice(km);
		System.out.println("��� : " + price + "��");
		System.out.println("���� ���� : " + t2.totalPrice + "��");
		System.out.println("----------------------------------------------");
		
			
		// �ӽ� �ð� setting
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		Taxi t3 = new Taxi("K5", "��ȫ��", "���");
		System.out.println(t3.info());
		//�մ�Ž
		System.out.println("���� �ݾ� : "+t3.initPrice() 
			+ "  �������� : " + t3.getMode() + "  ���� ���� : " +t3.totalPrice);
		//30km���� ������������ ���� ������
		System.out.println("���� �ݾ� : "+t3.sumPrice(30) 
			+ "  �������� : " + t3.getMode() + "  ���� ���� : " +t3.totalPrice);

		int upDown = 50;
		System.out.println("t2�� �ӵ��� " + upDown + "��ŭ ����!!!");
		int speed = t2.speedUp(upDown);
		System.out.println("t2�� �ӵ��� " + speed + "    " + t2.speed);

		upDown = 250;
		System.out.println("t2�� �ӵ��� " + upDown + "��ŭ ����!!!");
		speed = t2.speedUp(upDown);
		System.out.println("t2�� �ӵ��� " + speed + "    " + t2.speed);
		
		
		System.out.println(t2.hashCode() + "   " + t3.hashCode());
		Car car1 = new Taxi();

		System.out.println(t2.getClass() + "   " + car1.getClass());
		System.out.println(t2.getClass() + "   " + car1.getClass());
		//�񱳿�����(==) �� �⺻DataType�� ��쿡�� ���� ��������
		// ������DataType �� ���� �ּҰ��� ���Ѵ�.
		if(t2.equals(t3))
			System.out.println("t2�� t3�� �ּҰ��� �ٸ� ���̴�");
		else
			System.out.println("�ƴϴ�");


		System.out.println(t2.carName.hashCode() + "   " 
			+ t2.carName.hashCode());
		
		//Car c1 = new Car();
		Car c2 = new Taxi();
		Taxi t ;//= new Taxi();
		t = (Taxi)c2;
		
		
		//System.out.println(t2.initPrice());

		

		int i = 2; // 4
		double d = 3.4;  //8
		d = i;
	}
}
