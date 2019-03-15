import java.util.*;

public class TaxiGuest {
	public static void main(String[] args) {
		
		Taxi t1 = new Taxi();
		System.out.println(t1.info());

		Taxi t2 = new Taxi("K5", "감홍색", "기아");
		System.out.println(t2.info());

		int km = 20;
		System.out.println(t2.info() + "를 타고 구디에서 강남까지 " 
			+ km + "km이동!!!");
		int price = t2.calcPrice(km);
		System.out.println("요금 : " + price + "원");
		System.out.println("누적 수입 : " + t2.totalPrice + "원");

		km = 20;
		System.out.println(t2.info() + "를 타고 강남에서 구디까지 " 
			+ km + "km이동!!!");
		price = t2.calcPrice(km);
		System.out.println("요금 : " + price + "원");
		System.out.println("누적 수입 : " + t2.totalPrice + "원");
		System.out.println("----------------------------------------------");
		
			
		// 임시 시간 setting
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		Taxi t3 = new Taxi("K5", "감홍색", "기아");
		System.out.println(t3.info());
		//손님탐
		System.out.println("현재 금액 : "+t3.initPrice() 
			+ "  할증여부 : " + t3.getMode() + "  오늘 번돈 : " +t3.totalPrice);
		//30km미터 떨어진곳으로 가서 도착함
		System.out.println("현재 금액 : "+t3.sumPrice(30) 
			+ "  할증여부 : " + t3.getMode() + "  오늘 번돈 : " +t3.totalPrice);

		int upDown = 50;
		System.out.println("t2의 속도를 " + upDown + "만큼 가속!!!");
		int speed = t2.speedUp(upDown);
		System.out.println("t2의 속도를 " + speed + "    " + t2.speed);

		upDown = 250;
		System.out.println("t2의 속도를 " + upDown + "만큼 가속!!!");
		speed = t2.speedUp(upDown);
		System.out.println("t2의 속도를 " + speed + "    " + t2.speed);
		
		
		System.out.println(t2.hashCode() + "   " + t3.hashCode());
		Car car1 = new Taxi();

		System.out.println(t2.getClass() + "   " + car1.getClass());
		System.out.println(t2.getClass() + "   " + car1.getClass());
		//비교연산자(==) 는 기본DataType일 경우에는 값을 비교하지만
		// 참조형DataType 일 경우는 주소값을 비교한다.
		if(t2.equals(t3))
			System.out.println("t2와 t3는 주소값이 다른 차이다");
		else
			System.out.println("아니다");


		System.out.println(t2.carName.hashCode() + "   " 
			+ t2.carName.hashCode());
		
		//Car c1 = new Car();
		Car c2 = new Taxi();
		Taxi t ;//= new Taxi();
		t = (Taxi)c2;
		
		
		//System.out.println(t2.initPrice());

		

		int i = 2; // 4
		double d = 3.4;  //8
		d = i;
	}
}
