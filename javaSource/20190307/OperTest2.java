public class OperTest2 
{
	public static void main(String[] args) 
	{
		//연산자 우선순위
		int num1 = 13;
		int num2 = 5;
		int num3 = num1 + num2;

		
		System.out.println(num1 + " + " + num2 + " = " + num3);
		
		//135 가 나온다
		//앞에서 이미 String 으로 변환되서 오기 때문..
		System.out.println(num1 + " + " + num2 + " = " + num1 + num2);
		
		//( )  덕분에 먼저 연산 후 String 으로 변환
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));

		num3 = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + num3);

		num3 = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + num3);
		// * / % 가 제대로 작동하는 이유는 이 연산자는 + 보다 먼저 계산하기 때문..
		System.out.println(num1 + " * " + num2 + " = " + num1 * num2);
	
		num3 = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + num3);
		System.out.println(num1 + " / " + num2 + " = " + num1 / num2);

		num3 = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + num3);
		System.out.println(num1 + " % " + num2 + " = " + num1 % num2);

	}
}
