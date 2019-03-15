public class ForTest2 {
	public static void main(String[] args) {
		
		// 구구단 5단
		int dan = 5;
		
		System.out.println("*** 5단 ***");
		for(int i = 1 ; i < 10 ; i++){
			System.out.println("5 * " + i + " = " + (dan*i));
		}
		System.out.println("프로그램 종료!!");
	}
}
