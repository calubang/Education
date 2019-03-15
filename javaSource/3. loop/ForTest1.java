public class ForTest1 {
	public static void main(String[] args) {
		
		//1~10까지 출력
		/*for ( int i = 0; i<10 ; i++ ) {
			System.out.print(i + "\t");
		}
		System.out.println("프로그램 종료");
		*/	

		// 1 ~ 10 출력(홀수)
		int number = 0;
		for(number = 0; number < 10 ; number++ ){
			if ( number % 2 != 0 ) {
				System.out.print(number + "     ");	
			}
		}
		// 좀더 좋은 형태
		System.out.println("");
		for(number = 1; number < 11 ; number+=2 ){
			System.out.print(number + "     ");	
		}

		System.out.println("\n------------------------------------");
		//1~100까지 출력(10개 단위 줄바꿈)
		for(number = 1 ; number <= 100 ; number++ ){
			System.out.print(number+"  ");
			if ( number % 10 == 0 ) {
				System.out.println("");
			}	
		}
		System.out.print("프로그램 종료");
	}
}
