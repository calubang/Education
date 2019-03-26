package constructor;
/*
1. 가로 width, 세로 height
2. 넓이 : calcArea()
    둘레 : calcRound()
// default 사각형은 가로4 세로3 
// 가로가 4이고 세로가 3인 사격형의 넓이는 12이고 둘레는 14입니다
// 내 맘대로 가로 세로 정하기
*/
public class Rect {
	int width;
	int height;

	//생성자
	public Rect(){
		this(4, 3);	
	}
	public Rect(int width){
		this(width, 3);
	}
	/*
	public Rect(int height){
		this(4, height);
	}
	*/
	public Rect(int width, int height){
		if ( checkValue(width) )
			this.width = width;
		else
			this.width = 4;

		if ( checkValue(height) )
			this.height = height;
		else
			this.height = 3;
	}

	// 도형 올바른 값인지 확인
	public boolean checkValue(int value){
		if(value <= 0)
			return false;
		return true;
	}

	// 넓이구하기
	public int calcArea(){
		return this.width * this.height;
	}

	// 둘레구하기
	public int calcRound(){
		return (this.width + this.height) * 2;
	}

	// info
	// 가로가 4이고 세로가 3인 사격형의 넓이는 12이고 둘레는 14입니다
	public String info(){
		return "가로가 " + width + "이고 세로가 " + height + "인 사격형의 넓이는 "
				+ calcArea() + "이고 둘레는 " + calcRound() + " 입니다.";
	}
}
