public class Car {
	//���� ����
	String carName;
	String color;
	String maker;
	int speed;

	//������
	//this : �ڱ�Ŭ���� ������ �� �ִ� ��������
	//this() : �ڱ�Ŭ���� ������ ȣ��
	//this() �� �������� ù��° �ٿ����� ��� �����ϴ�
	public Car(){
		/*
		carName = "�Ÿ";
		color = "������";
		maker = "����";
		*/
		this("�Ÿ", "������", "����");
	}
	public Car(String color){
		/*
		this.carName = "�Ÿ";
		this.maker = "����";
		this.color = color;
		*/
		this("�Ÿ", color, "����");
	}
	public Car(String carName, String color){
		this(carName, color, "����");
	}
	public Car(String carName, String color, String maker){
		this.carName = carName;
		this.maker = maker;
		this.color = color;
	}
	//����
	public int calcArea(){
		// ���� ���θ� �̿��ؼ� ���̸� ���Ѱ��� return  
	}
	//�ѷ�
	public int calcRound(){
		// ���� ���θ� �̿��ؼ� �ѷ��� ���Ѱ��� return 
	}

	public void speedUp(){
		if(speedCheck())
			speed += 10;
	}

	public int speedUp(int speed){
		if(speedCheck())
			this.speed+= speed;
		return this.speed;
	}

	public void speedDown(){
		if(speedCheck())
			speed -= 10;
		else
			stop();
	}
	
	public int speedDown(int speed){
		if(speedCheck())
			this.speed -= speed;
		else
			stop();
		return this.speed;
	}

	public void stop(){
		speed = 0;
	}

	String info(){
		return "car ���̸� : " + carName 
			+ "   ���� : " + color + "   ������ : " + maker;
	}

	//rect
	String info(){
		return "�簢���� ���δ� : " + width + " d"
	}

	public boolean speedCheck(){
		if(speed < 0)
			return false;
		return true;
	}

}
