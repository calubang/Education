public class Car {
	// ���������� �ڵ����� null �� ����
	String carName = null;   // null �� ����ִ� carName �� �ٽ� null �� ���Խ�Ų ��Ȳ(��ȿ��)
	String color;
	String maker;
	int speed;
	
	//�ϳ��� �����ڸ� ������ ���� ���
	//default �����ڰ� �ڵ����� �����ȴ�
	public Car() {
	}
	
	public Car(String name, String nowColor, int nowSpeed) {
		carName = name;
		color = nowColor;
	}

	//����
	public void speedUp(){
		speed += 10;
	}
	
	//����
	public void speedDown(){
		speed -= 10;
		if ( speed < 0 )
			stop();
	}
	
	//����

	public void stop(){
		speed = 0;
	}
	
}
