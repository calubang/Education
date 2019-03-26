public class LoopTest190312 {
	public static void main(String[] args) {
		/*
		//while Test
		System.out.println("1~10까지 출력");
		int i = 0;
		while(i < 10){
			System.out.println(++i);
		}

		System.out.println("1~10까지의 수중 난수를 발생하시오.");
		boolean flag = true;
		int count = 0;
		while(flag){
			int number = (int)(Math.random() * 11);  // 0 ~ 10 까지
			count++;
			if ( number != 0 ) {
				System.out.println("number == " + number);	
			}else {
				System.out.println("0이 발생( " + count + " 번째 )되어 프로그램 종료!!!");
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
		System.out.println("이번 Lotto 번호는 : " + lottoNum1 + "    "  + lottoNum2 + "    " + lottoNum3);
		

		//WhileGugudan
		int dan = 2;
		int i = 1;

		System.out.println("*** 구구단 ***");
		while(i < 10){
			while(dan < 10){
				System.out.print(dan + " * " + i + " = " + (dan*i) + "    ");
				dan++;
			}
			System.out.println("");
			i++;
			dan = 2;
		}

		// 에러의 종류
		// 문법에러 : 구문 문제
		// 시스템 에러 : 컴퓨터적 문제
		// 논리 에러 : Logic 상의 문제
		
		*/
		// Lotto - 최종 - 
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

		System.out.println("이번 Lotto 번호는 : " + lottoNum1 + "    "  + lottoNum2 + "    " + lottoNum3 + "    " +  lottoNum4 + "    "  + lottoNum5 + "    " + lottoNum6);


		
        /*
		// break, continue
		// break : 시점에서 반복 종료
		// continue : 시점에서 아래 실행문을 수행하지 않고 다음 반복으로 넘어가서 수행
		int count = 0;;
		while ( count < 10 ) {
			count++;
			int number = (int)(Math.random() * 10);
			if( number == 0 ){
				System.out.println("number ==  " + number + " number가 0 이 나왔습니다. \n 프로그램 종료합니다.");
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
				System.out.println("number ==  " + number + " number가 0 이 나왔습니다.\n 다음으로 진행합니다.");
				continue;
			}
			System.out.println(count + ", number ==  " + number);
		}
		*/
	}
}
