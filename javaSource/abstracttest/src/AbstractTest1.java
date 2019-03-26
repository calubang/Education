import java.util.*;
public class AbstractTest1 {
	public static void main(String[] args) throws Exception {
		
		//1. 하위 클래스 참조
		//Calendar cal = new GregorianCalendar();	
		
		//2. 자신의 객체를 return 하는 static method.
		Calendar cal = Calendar.getInstance();
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);

		System.out.println(y + "년 " + m + "월 " + d + "일 " + h + "시 " + mi + "분 " + s + "초");

		//3. 외부 클래스 참조
		//Process 를 생성하기 위해서 Runtime 을 통해 생성
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("calc");

		//4. 자신의 생성자 이용
		//Calendar cal = new Calendar(){
			// abstract method 를 모두 Override 를 한다.
		//}
		
		
	}
}
