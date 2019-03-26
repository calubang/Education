public class SwitchTest1 {
	public static void main(String[] args) {
		
		int num = 3;
		switch ( num ) {
			case 1:
				System.out.println("1입니다.");
				break;
			case 2:
				System.out.println("2입니다.");
				break;
			case 3:
				System.out.println("3입니다.");
				break;
			case 4:
				System.out.println("4입니다.");
				break;
			default:
				System.out.println("기타입니다.");
		}

		char c = 'a';
		switch ( c ) {
			case 'a':
				System.out.println("a입니다.");
				break;
			case 'b':
				System.out.println("b입니다.");
				break;
			case 'c':
				System.out.println("c입니다.");
				break;
			case 'd':
				System.out.println("d입니다.");
				break;
			default:
				System.out.println("기타입니다.");
		}
		
		String str = "java";
		switch ( str ) {
			case "oracle":
				System.out.println("1입니다.");
				break;
			case "java":
				System.out.println("2입니다.");
				break;
			case "jsp":
				System.out.println("3입니다.");
				break;
			case "script":
				System.out.println("4입니다.");
				break;
			default:
				System.out.println("기타입니다.");
		}
		
		
		System.out.println("프로그램종료!!");
	}
}
