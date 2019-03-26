/*
����      ��Car

����		�ý�Taxi									����Bus									Ʈ��Truck
			���price								�°���pcount							�߷�weight, �ִ��߷�maxWeight
			��ݰ��int calcPrice(int km)		Ÿ��int getOn(int pcount)			����loadUp()
			3800 + km��100��					������int getOut(int pcount)		����loadDown()

�Ϲݹ��� 12������
1. ���
	�����(totalPrice) : ����뿡 ����ִ� �ݾ�
	�⺻���(price)
		��� : 500��
		û�ҳ� : 700��
		���� : 900��
2. ������ ź�� 
3. ��ݰ��(calcPrice())
	�°��� ���̸� üũ�ؼ� ��ݰ���� �ϰ� ����뿡 �߰�
4. �ִ�°� : 4��
5. �����ҿ��� Ÿ�� �����°� 
6. �����°������� ��ݰ���� ���� �ʴ´�.
*/
public class Bus {
	//���� ����
	//���� �°���, �Ѱ� �°���
	//�����
	int MAX_GUEST = 3;
	int currentGuest;
	int totalPrice;
	int busNumber;

	public Bus(int busNumber){
		this.busNumber = busNumber;
		currentGuest = 0;
		totalPrice = 0;
	}
		
	//���� ����
	//�����Ұ�..
	//public String doorOpen(BusGuest onGuest){}
	//���� �ݴ�
	//public String doorOpen(int offGuest){}

	//�°��� ź�� -> �����, �����ο�+
	public boolean takeOn(BusGuest onGuest){
		if ( currentGuest < MAX_GUEST ) {
			totalPrice += calcPrice(onGuest.getAge());
			currentGuest++;
			return true;
		} else{
			System.out.println(busNumber + "�� ������ ���� á���ϴ�.");
			return false;	
		}
	}
	//�°��� ������. -> �����ο�-
	public boolean takeOff(){
		if ( currentGuest > 0 ) {
			currentGuest--;
			System.out.println("�°��� ���Ƚ��ϴ�.");
			return true;
		} else {
			System.out.println("���� �°��� �����ϴ�.");
			return false;
		}
		
	}

	//��ݰ��
	public int calcPrice(String age){
		int price = 0;
		switch ( age ) {
			case "����":
				price = 900;
				break;
			case "û�ҳ�":
				price = 700;
				break;
			case "���":
				price = 500;
				break;
		}
		System.out.println(age + "("+ price + "��)�°� �Դϴ�.");
		return price;
	}

	//�Ϸ�����
	public int finish(){
		int totalPrice = this.totalPrice;
		this.totalPrice = 0;
		this.currentGuest = 0;
		System.out.println(busNumber + "�� � �����մϴ�. ���� ������ " 
			+ totalPrice);
		return totalPrice;
	}

	//�Ϸ����
	public void init(){
		totalPrice = 0;
		currentGuest = 0;
		System.out.println(busNumber 
			+ "�� � �����մϴ�. ���������ϼ���");
	}

	//���� ���� ����
	public void info() {
		System.out.println(busNumber + "�� ����°��� : " + currentGuest 
			+ "��" + "    ���� : " + totalPrice + "\n");
	}
}
