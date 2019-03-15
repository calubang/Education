public class Car {
	//변수 선언
	String carName;
	String color;
	String maker;
	int speed;

	public Car(){
		this("쏘나타", "검정색", "현대");
	}
	public Car(String color){
		this("쏘나타", color, "현대");
	}
	public Car(String carName, String color){
		this(carName, color, "현대");
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
		return maker + " 에서 만든 " + color + "  " + carName;

		//return "car 차이름 : " + carName 
		//	+ "   색상 : " + color + "   제조사 : " + maker;
	}

	public boolean speedCheck(){
		if(speed < 0)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return maker + " 에서 만든 " + color + "  " + carName;
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
