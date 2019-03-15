public class Car {
	//���� ����
	String carName;
	String color;
	String maker;
	int speed;

	public Car(){
		this("�Ÿ", "������", "����");
	}
	public Car(String color){
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

	int speedUp(int speed){
		if(speedCheck())
			this.speed+= speed;
		return this.speed;
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
		return maker + " ���� ���� " + color + "  " + carName;

		//return "car ���̸� : " + carName 
		//	+ "   ���� : " + color + "   ������ : " + maker;
	}

	public boolean speedCheck(){
		if(speed < 0)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return maker + " ���� ���� " + color + "  " + carName;
	}
	
	// 
	@Override
	public boolean equals(Object obj){
		Car car = (Car)obj;
		System.out.println(obj.getClass());
		if(carName == car.carName)
			return true;
		return false;
	}

	
}
