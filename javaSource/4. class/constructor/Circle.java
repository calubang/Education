/*
1. 반지름 radius
2. 넓이 : calcArea()
    둘레 : calcRound()
// 반지름이 4인 원의 넓이는 xxx 이고 둘레는 xxx 입니다.
// 내 맘대로 반지름
*/
public class Circle {
	int radius;
	double pi;
	
	//생성자
	public Circle(){
		this(4);
	}
	public Circle(int radius){
		if ( checkRadius(radius) )
			this.radius = radius;
		else
			this.radius = 4;
		this.pi = Math.PI;
	}

	// 반지름 값 확인
	public boolean checkRadius(int radius){
		if(radius <= 0)
			return false;
		return true;
	}
	
	// 원의 넓이
	public double calcArea(){
		return  Math.round((double)radius * (double)radius * pi * 100.0)/100.0;
	}

	// 원의 둘레
	public double calcRound(){
		return Math.round(2 * pi * (double)radius * 100.0)/100.0;
	}
	
	// info
	// 반지름이 4인 원의 넓이는 xxx 이고 둘레는 xxx 입니다.
	public String info(){
		return "반지름이 " + radius + "인 원의 넓이는 " + calcArea() + " 이고 둘레는 "
				+ calcRound() + " 입니다.";
	}
}
