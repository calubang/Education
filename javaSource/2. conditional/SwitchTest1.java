public class SwitchTest1 {
	public static void main(String[] args) {
		
		int num = 3;
		switch ( num ) {
			case 1:
				System.out.println("1�Դϴ�.");
				break;
			case 2:
				System.out.println("2�Դϴ�.");
				break;
			case 3:
				System.out.println("3�Դϴ�.");
				break;
			case 4:
				System.out.println("4�Դϴ�.");
				break;
			default:
				System.out.println("��Ÿ�Դϴ�.");
		}

		char c = 'a';
		switch ( c ) {
			case 'a':
				System.out.println("a�Դϴ�.");
				break;
			case 'b':
				System.out.println("b�Դϴ�.");
				break;
			case 'c':
				System.out.println("c�Դϴ�.");
				break;
			case 'd':
				System.out.println("d�Դϴ�.");
				break;
			default:
				System.out.println("��Ÿ�Դϴ�.");
		}
		
		String str = "java";
		switch ( str ) {
			case "oracle":
				System.out.println("1�Դϴ�.");
				break;
			case "java":
				System.out.println("2�Դϴ�.");
				break;
			case "jsp":
				System.out.println("3�Դϴ�.");
				break;
			case "script":
				System.out.println("4�Դϴ�.");
				break;
			default:
				System.out.println("��Ÿ�Դϴ�.");
		}
		
		
		System.out.println("���α׷�����!!");
	}
}
