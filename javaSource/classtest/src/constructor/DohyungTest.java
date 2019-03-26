package constructor;
public class DohyungTest{
	
	public static void main(String[] args) {
		// default 사각형은 가로4 세로3 
		// 가로가 4이고 세로가 3인 사격형의 넓이는 12이고 둘레는 14입니다.
		Rect r1 = new Rect();
		System.out.println(r1.calcRound() + "   "  + r1.calcArea());
		
		System.out.println(r1.info());

		// 내 맘대로 가로 세로 정하기
		Rect r2 = new Rect(7, 9);
		System.out.println(r2.info());
		
		// default 원은 반지름4
		// 반지름이 4인 원의 넓이는 xxx 이고 둘레는 xxx 입니다.
		Circle c1 = new Circle();
		System.out.println(c1.info());
		// 내 맘대로 반지름
		Circle c2 = new Circle(-3);
		System.out.println(c2.info());
	}
}