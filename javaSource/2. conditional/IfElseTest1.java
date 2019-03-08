public class IfElseTest1 {
	public static void main(String[] args) {

		int x = 10;
		int y = 10;
		/*
		if ( x > y ){
			System.out.println(x + "는 " + y + " 보다 크다");
		} else {
			System.out.println(x + "는 " + y + " 보다 작다");
		}
		*/
		
		//조건식에서는 == != 가 좀더 빠르다.
		// 그러므로 == 비교를 먼저 하는것이 유리
		String result = "보다";
		if( x > y ){
			result += "크다";
		} else {
			if ( x == y  ){
				result = "은 같다";
			} else {
				result += "작다";
			}
		}
		System.out.println(x + "는 " + y + result);
		// 남자 여자 IF ~ELSE 바꿔보기

		System.out.println("프로그램 종료!!!!");
	}
}