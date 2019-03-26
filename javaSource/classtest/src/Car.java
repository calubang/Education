public class Car {
	// 전역변수는 자동으로 null 이 들어간다
	String carName = null;   // null 이 들어있는 carName 에 다시 null 을 대입시킨 상황(비효율)
	String color;
	String maker;
	int speed;
	
	//하나도 생성자를 만들지 않은 경우
	//default 생성자가 자동으로 생성된다
	public Car() {
	}
	
	public Car(String name, String nowColor, int nowSpeed) {
		carName = name;
		color = nowColor;
	}

	//가속
	public void speedUp(){
		speed += 10;
	}
	
	//감속
	public void speedDown(){
		speed -= 10;
		if ( speed < 0 )
			stop();
	}
	
	//정지

	public void stop(){
		speed = 0;
	}
	
}
