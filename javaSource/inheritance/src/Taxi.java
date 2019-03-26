/*
����      ��Car

����		�ý�Taxi 150							����Bus  110							Ʈ��Truck 100
			���price								�°���pcount							�߷�weight, �ִ��߷�maxWeight
			��ݰ��int calcPrice(int km)		Ÿ��int getOn(int pcount)			����loadUp()
			3800 + km��100��					������int getOut(int pcount)		����loadDown()

1. ���
	�⺻���(basicPrice)
		�Ϲ� : 3800
		�ɾ� : 5000
	�����(totalPrice)
	���(price)
		�Ϲ� : 100/km
		�ɾ� : 150/km
2. ��ݰ��(calcPrice())
3. �ɾ����� : 0 ~ 6��
*/
import java.util.*;

public class Taxi extends Car{
	// ���
	// �⺻���, �ѿ��, ������, km����
	// mode 0 �մԾ���, 1 �Ϲݼմ�  2 �ɾ߼մ�
	int basicPrice;
	int totalPrice;
	int price;
	int pricePerKm;
	int mode;
	//�׽�Ʈ��
	int hour;

	// ������
	public Taxi(){
		//super() �� �⺻���� ������ �ٴ´�. �츮�� �������� �ʾƵ�..
		super();
		basicPrice = 3800;
		pricePerKm = 100;

		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
	} 
	public Taxi(String carName, String color, String maker){
		super(carName, color, maker);
		basicPrice = 3800;
		pricePerKm = 100;

		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
	}

	// �մ��� Ÿ�ڸ��� �ϴ� �ൿ
	// ��踦 �۵���Ű�� ù ����� ����.
	public int initPrice(){
		// ��� �۵�
		changeMode();
		System.out.println("����մϴ�.");
		// ���� ����
		return price = basicPrice;
	}
	
	// ��ݰ��
	public int calcPrice(int km){
		price += (km * pricePerKm);
		return price;
	}

	// �մ��� ������
	public int sumPrice(int km){
		//�մ��� ������ ��� ���
		//����� ������ �ѹ����� �߰�
		totalPrice += calcPrice(km);
		//���� �ý��� mode�� �ٽ� �ǵ�����
		changeMode();
		return price;
	}
	
	// mode ����
	public void changeMode(){
		switch ( mode ) {
			case 0:
				if(hour >= 0 && hour < 6){
					mode = 2;
					basicPrice = 5000;
					pricePerKm = 150;
				} else {
					mode = 1;
					basicPrice = 3800;
					pricePerKm = 100;
				}
				break;
			case 1:
			case 2:
				mode = 0;
				pricePerKm = 0;
				break;
			default :
				System.out.println("����");
		}
	}

	//mode ���
	public String getMode(){
		switch ( mode ) {
			case 0:
				return "�մԾ���";
			case 1:
				return "�Ϲ�";
			case 2:
				return "����";
			default :
				return "����";
		}
	}
	
	// ������
	// Taxi ������ ���Ѽӵ� 150�� ����
	@Override
	public int speedUp(int speed){
		if(super.speedUp(speed) > 150)
			this.speed = 150;
		return this.speed;
	}

	@Override
	public String toString(){
		return super.toString() + "(Taxi)";
	}
}
