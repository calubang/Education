public class Gugudan {
	public static void main(String[] args) {
		// ���� ������
		int dan = 0;

		System.out.println("*** ������1 ***");
		for(int i = 1 ; i < 10 ; i++){
			for(dan = 2 ; dan < 10 ; dan++){
				System.out.print(dan + "*" + i + "=" + (dan*i) + "    ");
			}
			System.out.println("");
		}
		
		//���� ������
		System.out.println("*** ������2 ***");
		for(dan = 2 ; dan < 10 ; dan++){
			for(int i = 1 ; i < 10 ; i++ ){
				System.out.print(dan + "*" + i + "=" + (dan*i) + "    ");
			}
			System.out.println("");
		}
		System.out.println("���α׷� ����!!");
	}
}
