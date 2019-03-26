/*
Lotto
1 - 3 까지의 서로 다른 난수 3개 발생

*/

public class ForLotto {
	public static void main(String[] args) {
		
		//좋지 않은 선언
		//int num1, num2, num3;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		// num1 할당
		num1 = (int)(Math.random()*3) + 1;
		for ( ; ; ) {
			num2 = (int)(Math.random()*3) + 1;
			if ( num1 != num2 ) {
				for( ; ; ){
					num3 = (int)(Math.random()*3) + 1;
					if( (num1 != num3) && (num2 != num3) ) {
						break;
					}
				}
				break;
			}
		}

		System.out.println("Lotto 번호는 " + num1 + "   " + num2 + "   " + num3);
		System.out.println("프로그램 종료!!");
	}
}
