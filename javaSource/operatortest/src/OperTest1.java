public class OperTest1 {
	public static void main(String[] args) {
		// 증감 연산자
		int x = 10;
		System.out.println(x);
		System.out.println(x++ + "     " + x);
		System.out.println(--x + "     " + x);
		System.out.println(x++ + "     " + x);
		System.out.println(++x + "     " + x);
		System.out.println(x-- + "     " + x);
		System.out.println(--x + "     " + x);
		System.out.println(x++ + "     " + x);
		System.out.println(x);

		char c = 'a';
		System.out.println("c == " + c);
		// 강제 형변환 (data type)변수명
		System.out.println("(int)c == " + (int) c);

		// 자동형변환
		// 작은것을 큰공간으로 넣는것은 가능
		int y = c;
		System.out.println("y == " + y);

		// int(4byte) 를 char (2byte) 안에 넣을 수 없어서 오류발생
		// 강제형변환
		c = (char) y;
		System.out.println("c == " + c);

		// 타입변환이 가능한 것만 가능
		// boolean b = true;
		// int z = b;

		boolean b = true;
		//z = (int) b;
	}
}
