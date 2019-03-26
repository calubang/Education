/*
상위      차Car

하위		택시Taxi 150							버스Bus  110							트럭Truck 100
			요금price								승객수pcount							중량weight, 최대중량maxWeight
			요금계산int calcPrice(int km)		타다int getOn(int pcount)			상차loadUp()
			3800 + km당100원					내리다int getOut(int pcount)		하차loadDown()

1. 요금
	기본요금(basicPrice)
		일반 : 3800
		심야 : 5000
	요금합(totalPrice)
	요금(price)
		일반 : 100/km
		심야 : 150/km
2. 요금계산(calcPrice())
3. 심야할증 : 0 ~ 6시
*/
import java.util.*;

public class Taxi extends Car{
	// 요금
	// 기본요금, 총요금, 현재요금, km당요금
	// mode 0 손님없음, 1 일반손님  2 심야손님
	int basicPrice;
	int totalPrice;
	int price;
	int pricePerKm;
	int mode;
	//테스트용
	int hour;

	// 생성자
	public Taxi(){
		//super() 는 기본으로 무조건 붙는다. 우리가 선언하지 않아도..
		super();
		basicPrice = 3800;
		pricePerKm = 100;

		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
	} 
	public Taxi(String carName, String color, String maker){
		super(carName, color, maker);
		basicPrice = 3800;
		pricePerKm = 100;

		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
	}

	// 손님이 타자마자 하는 행동
	// 기계를 작동시키고 첫 요금을 띄운다.
	public int initPrice(){
		// 기계 작동
		changeMode();
		System.out.println("출발합니다.");
		// 가격 설정
		return price = basicPrice;
	}
	
	// 요금계산
	public int calcPrice(int km){
		price += (km * pricePerKm);
		return price;
	}

	// 손님이 내릴때
	public int sumPrice(int km){
		//손님이 내야할 요금 계산
		//계산후 오늘의 총번돈에 추가
		totalPrice += calcPrice(km);
		//현재 택시의 mode를 다시 되돌린다
		changeMode();
		return price;
	}
	
	// mode 변경
	public void changeMode(){
		switch ( mode ) {
			case 0:
				if(hour >= 0 && hour < 6){
					mode = 2;
					basicPrice = 5000;
					pricePerKm = 150;
				} else {
					mode = 1;
					basicPrice = 3800;
					pricePerKm = 100;
				}
				break;
			case 1:
			case 2:
				mode = 0;
				pricePerKm = 0;
				break;
			default :
				System.out.println("오류");
		}
	}

	//mode 출력
	public String getMode(){
		switch ( mode ) {
			case 0:
				return "손님없음";
			case 1:
				return "일반";
			case 2:
				return "할증";
			default :
				return "오류";
		}
	}
	
	// 재정의
	// Taxi 에서는 제한속도 150을 구현
	@Override
	public int speedUp(int speed){
		if(super.speedUp(speed) > 150)
			this.speed = 150;
		return this.speed;
	}

	@Override
	public String toString(){
		return super.toString() + "(Taxi)";
	}
}
