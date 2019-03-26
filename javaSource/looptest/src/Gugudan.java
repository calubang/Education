public class Gugudan {
	public static void main(String[] args) {
		// 세로 구구단
		int dan = 0;

		System.out.println("*** 구구단1 ***");
		for(int i = 1 ; i < 10 ; i++){
			for(dan = 2 ; dan < 10 ; dan++){
				System.out.print(dan + "*" + i + "=" + (dan*i) + "    ");
			}
			System.out.println("");
		}
		
		//가로 구구단
		System.out.println("*** 구구단2 ***");
		for(dan = 2 ; dan < 10 ; dan++){
			for(int i = 1 ; i < 10 ; i++ ){
				System.out.print(dan + "*" + i + "=" + (dan*i) + "    ");
			}
			System.out.println("");
		}
		System.out.println("프로그램 종료!!");
	}
}
