public class ForTest1 {
	public static void main(String[] args) {
		
		//1~10���� ���
		/*for ( int i = 0; i<10 ; i++ ) {
			System.out.print(i + "\t");
		}
		System.out.println("���α׷� ����");
		*/	

		// 1 ~ 10 ���(Ȧ��)
		int number = 0;
		for(number = 0; number < 10 ; number++ ){
			if ( number % 2 != 0 ) {
				System.out.print(number + "     ");	
			}
		}
		// ���� ���� ����
		System.out.println("");
		for(number = 1; number < 11 ; number+=2 ){
			System.out.print(number + "     ");	
		}

		System.out.println("\n------------------------------------");
		//1~100���� ���(10�� ���� �ٹٲ�)
		for(number = 1 ; number <= 100 ; number++ ){
			System.out.print(number+"  ");
			if ( number % 10 == 0 ) {
				System.out.println("");
			}	
		}
		System.out.print("���α׷� ����");
	}
}
