public class Car {
	//변수 선언
	String carName;
	String color;
	String maker;
	int speed;

	//생성자
	//this : 자기클래스 참조할 수 있는 참조변수
	//this() : 자기클래스 생성자 호출
	//this() 는 생성자의 첫번째 줄에서만 사용 가능하다
	public Car(){
		/*
		carName = "쏘나타";
		color = "검정색";
		maker = "현대";
		*/
		this("쏘나타", "검정색", "현대");
	}
	public Car(String color){
		/*
		this.carName = "쏘나타";
		this.maker = "현대";
		this.color = color;
		*/
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
	//넓이
	public int calcArea(){
		// 가로 세로를 이용해서 넓이를 구한값을 return  
	}
	//둘레
	public int calcRound(){
		// 가로 세로를 이용해서 둘레를 구한값을 return 
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
		return "car 차이름 : " + carName 
			+ "   색상 : " + color + "   제조사 : " + maker;
	}

	//rect
	String info(){
		return "사각형의 가로는 : " + width + " d"
	}

	public boolean speedCheck(){
		if(speed < 0)
			return false;
		return true;
	}

}
