public class LoopTest190312 {
	public static void main(String[] args) {
		/*
		//while Test
		System.out.println("1~10���� ���");
		int i = 0;
		while(i < 10){
			System.out.println(++i);
		}

		System.out.println("1~10������ ���� ������ �߻��Ͻÿ�.");
		boolean flag = true;
		int count = 0;
		while(flag){
			int number = (int)(Math.random() * 11);  // 0 ~ 10 ����
			count++;
			if ( number != 0 ) {
				System.out.println("number == " + number);	
			}else {
				System.out.println("0�� �߻�( " + count + " ��° )�Ǿ� ���α׷� ����!!!");
				flag = false;
			}
		}
		

		// While Lotto
		int lottoNum1 = 0;
		int lottoNum2 = 0;
		int lottoNum3 = 0;
		boolean flag = true;

		lottoNum1 = (int)(Math.random() * 3)+1;
		while(flag){
			lottoNum2 = (int)(Math.random() * 3)+1;
			if(lottoNum1 != lottoNum2){
				flag = false;
			}
		}
		
		flag = true;
		while(flag){
			lottoNum3 = (int)(Math.random() * 3 )+1;
			if((lottoNum3 != lottoNum1) && (lottoNum3 != lottoNum2)){
				flag = false;
			}
		}
		System.out.println("�̹� Lotto ��ȣ�� : " + lottoNum1 + "    "  + lottoNum2 + "    " + lottoNum3);
		

		//WhileGugudan
		int dan = 2;
		int i = 1;

		System.out.println("*** ������ ***");
		while(i < 10){
			while(dan < 10){
				System.out.print(dan + " * " + i + " = " + (dan*i) + "    ");
				dan++;
			}
			System.out.println("");
			i++;
			dan = 2;
		}

		// ������ ����
		// �������� : ���� ����
		// �ý��� ���� : ��ǻ���� ����
		// �� ���� : Logic ���� ����
		
		*/
		// Lotto - ���� - 
		int lottoNum1 = 0;
		int lottoNum2 = 0;
		int lottoNum3 = 0;
		int lottoNum4 = 0;
		int lottoNum5 = 0;
		int lottoNum6 = 0;


		lottoNum1 = (int)(Math.random() *45) + 1; 
		do {
			lottoNum2 = (int)(Math.random() *45) + 1; 
		} while ( lottoNum1 == lottoNum2 );
		
		do {
			lottoNum3 = (int)(Math.random() *45) + 1; 
		} while ( (lottoNum3 == lottoNum1) || (lottoNum3 == lottoNum2) );
		
		do {
			lottoNum4 = (int)(Math.random() *45) + 1; 
		} while ( (lottoNum4 == lottoNum1) || (lottoNum4 == lottoNum2) || (lottoNum4 == lottoNum3) );
		
		do {
			lottoNum5 = (int)(Math.random() *45) + 1; 
		} while ( (lottoNum5 == lottoNum1) || (lottoNum5 == lottoNum2) || (lottoNum5 == lottoNum3) || (lottoNum5 == lottoNum4));

		do {
			lottoNum6 = (int)(Math.random() *45) + 1; 
		} while ( (lottoNum6 == lottoNum1) || (lottoNum6 == lottoNum2) || (lottoNum6 == lottoNum3) || (lottoNum6 == lottoNum4) || (lottoNum6 == lottoNum5));

		System.out.println("�̹� Lotto ��ȣ�� : " + lottoNum1 + "    "  + lottoNum2 + "    " + lottoNum3 + "    " +  lottoNum4 + "    "  + lottoNum5 + "    " + lottoNum6);


		
        /*
		// break, continue
		// break : �������� �ݺ� ����
		// continue : �������� �Ʒ� ���๮�� �������� �ʰ� ���� �ݺ����� �Ѿ�� ����
		int count = 0;;
		while ( count < 10 ) {
			count++;
			int number = (int)(Math.random() * 10);
			if( number == 0 ){
				System.out.println("number ==  " + number + " number�� 0 �� ���Խ��ϴ�. \n ���α׷� �����մϴ�.");
				break;
			}
			System.out.println("number ==  " + number);
		}
		
		System.out.println("--------------------------------------------------------------------");

		count = 0;;
		while ( count < 10 ) {
			count++;
			int number = (int)(Math.random() * 10);
			if( number == 0 ){
				System.out.println("number ==  " + number + " number�� 0 �� ���Խ��ϴ�.\n �������� �����մϴ�.");
				continue;
			}
			System.out.println(count + ", number ==  " + number);
		}
		*/
	}
}
