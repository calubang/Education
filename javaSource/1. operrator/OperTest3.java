public class OperTest3{
	public static void main(String[] args) {
		
		int x = 10;
		int y = 15;
		int z = 20;
		System.out.println(x + " > " + y + " : " + (x > y) );
		
		//산술 연산이 비교연산보다 우선순위가 높다
		System.out.println(x + " ==  " + z + " / 2 : " + (x > z -11) );
		
		System.out.println(x < y && y > z);   // false

		System.out.println(x < y || y > z);   // true
	}
}
