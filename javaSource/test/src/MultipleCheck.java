public class MultipleCheck {

	public void printNumber(int number){
		String str = "";
		int twoCount = 0;
		int threeCount = 0;
		int fiveCount = 0;
		for(int i =1 ; i<=number ; i++){
			str += i + ".";
			if ( (i % 2) == 0 ) {
				str += " 2�� ���";
				twoCount++;
			}
			if ( (i % 3) == 0 ) {
				str += " 3�� ���";
				threeCount++;
			}
			if ( (i % 5) == 0 ) {
				str += " 5�� ���";
				fiveCount++;
			}
			System.out.println(str);
			str = "";
		}
		System.out.println("===== ��� Ƚ�� =====");
		System.out.println("2�� ���  :  " + twoCount);
		System.out.println("2�� ���  :  " + threeCount);
		System.out.println("2�� ���  :  " + fiveCount);
	}
	public static void main(String[] args) {
		
		int number = 20;
		System.out.println(number + "ȸ���� �����մϴ�--------------");
		MultipleCheck mc = new MultipleCheck();
		mc.printNumber(number);
	}
}
