public class IfTest1 {
	public static void main(String[] args) {
		
		int x = 10;
		int y = 70;
		
		if( x > y ){
			System.out.println("x가 크다");
		}
		
		
		int jumin = 1;
		// 기본은 남자
		String result = "남자";
		
		//if 걸리면 여자
		if( (jumin % 2) == 0){
			result = "여자";
		}
		//결과출력
		System.out.println(result + " 입니다.");
		System.out.println("프로그램 종료");
	}
}
