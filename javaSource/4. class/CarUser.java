public class CarUser {
	public static void main(String[] args) {
		
		//Oracle에서의 null : 알수없음
		//java에서의 null : 아직 안만들었다. 참조할수 없다.
		Car car1 = null;
		//System.out.println("1. 차이름 : " + car1.carName + "   색상 : " + car1.color + "   제조사 : " + car1.maker);
		car1 = new Car();
		System.out.println("1. 차이름 : " + car1.carName + "   색상 : " + car1.color + "   제조사 : " + car1.maker);
		car1.carName = "쏘나타";
		car1.color = "검정색";
		car1.maker = "현대";
		System.out.println("2. 차이름 : " + car1.carName + "   색상 : " + car1.color + "   제조사 : " + car1.maker);

		Car car2 = new Car();
		System.out.println("3. 차이름 : " + car2.carName + "   색상 : " + car2.color + "   제조사 : " + car2.maker);
		car2.carName = "K5";
		car2.color = "흰색";
		car2.maker = "기아";
		System.out.println("3. 차이름 : " + car2.carName + "   색상 : " + car2.color + "   제조사 : " + car2.maker);

		System.out.println("최초" + car1.carName + "의 속도 : " + car1.speed);
		System.out.println("car1의 속도를 2회 증가!!!!");
		car1.speedUp();
		car1.speedUp();
		System.out.println("2회 증가후" + car1.carName + "의 속도 : " + car1.speed);
		for(int i =0 ; i<8 ; i++){
			car1.speedUp();
		}
		System.out.println("8회 증가후" + car1.carName + "의 속도 : " + car1.speed);
		System.out.println("car1의 속도를 4회 감소!!!!");
		for(int i = 0 ; i< 20 ; i++){
			car1.speedDown();
		} 
		System.out.println("4회 감소후" + car1.carName + "의 속도 : " + car1.speed);
	}
}
