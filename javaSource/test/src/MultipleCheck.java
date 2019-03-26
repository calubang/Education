public class MultipleCheck {

	public void printNumber(int number){
		String str = "";
		int twoCount = 0;
		int threeCount = 0;
		int fiveCount = 0;
		for(int i =1 ; i<=number ; i++){
			str += i + ".";
			if ( (i % 2) == 0 ) {
				str += " 2의 배수";
				twoCount++;
			}
			if ( (i % 3) == 0 ) {
				str += " 3의 배수";
				threeCount++;
			}
			if ( (i % 5) == 0 ) {
				str += " 5의 배수";
				fiveCount++;
			}
			System.out.println(str);
			str = "";
		}
		System.out.println("===== 출력 횟수 =====");
		System.out.println("2의 배수  :  " + twoCount);
		System.out.println("2의 배수  :  " + threeCount);
		System.out.println("2의 배수  :  " + fiveCount);
	}
	public static void main(String[] args) {
		
		int number = 20;
		System.out.println(number + "회까지 진행합니다--------------");
		MultipleCheck mc = new MultipleCheck();
		mc.printNumber(number);
	}
}
