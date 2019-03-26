/*
상위      차Car

하위		택시Taxi									버스Bus									트럭Truck
			요금price								승객수pcount							중량weight, 최대중량maxWeight
			요금계산int calcPrice(int km)		타다int getOn(int pcount)			상차loadUp()
			3800 + km당100원					내리다int getOut(int pcount)		하차loadDown()

일반버스 12번버스
1. 요금
	요금합(totalPrice) : 요금통에 들어있는 금액
	기본요금(price)
		어린이 : 500원
		청소년 : 700원
		성인 : 900원
2. 버스에 탄다 
3. 요금계산(calcPrice())
	승객의 나이를 체크해서 요금계산을 하고 요금통에 추가
4. 최대승객 : 4명
5. 정류소에서 타고 내리는것 
6. 내리는곳에따른 요금계산은 하지 않는다.
*/
public class Bus {
	//변수 선언
	//현재 승객수, 한계 승객수
	//요금통
	int MAX_GUEST = 3;
	int currentGuest;
	int totalPrice;
	int busNumber;

	public Bus(int busNumber){
		this.busNumber = busNumber;
		currentGuest = 0;
		totalPrice = 0;
	}
		
	//문을 연다
	//구현불가..
	//public String doorOpen(BusGuest onGuest){}
	//문을 닫다
	//public String doorOpen(int offGuest){}

	//승객이 탄다 -> 돈계산, 현재인원+
	public boolean takeOn(BusGuest onGuest){
		if ( currentGuest < MAX_GUEST ) {
			totalPrice += calcPrice(onGuest.getAge());
			currentGuest++;
			return true;
		} else{
			System.out.println(busNumber + "번 버스가 가득 찼습니다.");
			return false;	
		}
	}
	//승객이 내린다. -> 현재인원-
	public boolean takeOff(){
		if ( currentGuest > 0 ) {
			currentGuest--;
			System.out.println("승객이 내렸습니다.");
			return true;
		} else {
			System.out.println("내릴 승객이 없습니다.");
			return false;
		}
		
	}

	//요금계산
	public int calcPrice(String age){
		int price = 0;
		switch ( age ) {
			case "성인":
				price = 900;
				break;
			case "청소년":
				price = 700;
				break;
			case "어린이":
				price = 500;
				break;
		}
		System.out.println(age + "("+ price + "원)승객 입니다.");
		return price;
	}

	//하루정리
	public int finish(){
		int totalPrice = this.totalPrice;
		this.totalPrice = 0;
		this.currentGuest = 0;
		System.out.println(busNumber + "번 운영 종료합니다. 오늘 수입은 " 
			+ totalPrice);
		return totalPrice;
	}

	//하루시작
	public void init(){
		totalPrice = 0;
		currentGuest = 0;
		System.out.println(busNumber 
			+ "번 운영 시작합니다. 안전운전하세요");
	}

	//현재 버스 정보
	public void info() {
		System.out.println(busNumber + "번 현재승객수 : " + currentGuest 
			+ "명" + "    번돈 : " + totalPrice + "\n");
	}
}
