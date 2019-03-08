public class IfElseIfTest1 {
	public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		
		//y = 5;

		String result = " 보다";
		if( x == y ){
			result = " 과 같다";
		} else if ( x > y ){
			result += " 크다";
		} else {
			result += " 작다";
		}
		
		// 일반적으로는 삼항 연산자가 속도면에서는 유리하나
		// 가독성이 똥망이라 잘 안쓰인다.
		System.out.println(x + " 은 " + y + result);
		System.out.println("프로그램 종료");
	}
}
