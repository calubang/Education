package constructor;
public class StarCraft {
	public static void main(String[] args) {
		//마린
		Marine my = new Marine("나");   // 내 마린
		Marine com = new Marine("컴퓨터");   // 컴퓨터 마린
		
		// 시작화면
		// 내 체력 : 100
		// 적 체력 : 100
		int count = 2;
		System.out.println("적이 나를 "+count+"회 공격!!!!");
		my.attack(com, count);
		System.out.println(my.info(com));
	
		// 내 체력 : 100    적 체력 : 80
		count = 4;
		System.out.println("적이 나를 "+count+"회 공격!!!!");
		com.attack(my, count);
		System.out.println(my.info(com));
		// 내 체력 : 60     적 체력 : 80

		System.out.println("모드 변경!!!");
		my.changeMode();
		System.out.println(my.info(com));
		// 내 체력 : 35     적 체력 : 80
		count = 3;
		System.out.println("내가 적을 "+count+"회 공격!!!!");
		my.attack(com, count);
		System.out.println(my.info(com));
		// 내 체력 : 35     적 체력 : 35

		System.out.println("모드 변경!!!");
		my.changeMode();
		System.out.println(my.info(com));
		// 경고 : 모드 변경 불가~!!!!!
		
		System.out.println("모드 변경!!!");
		my.changeMode();
		System.out.println(my.info(com));
		// 경고 : 모드 변경 불가~!!!!!

		count = 4;
		System.out.println("내가 적을 " + count + " 회 공격!!!!");
		my.attack(com, count);
		System.out.println(my.info(com));
		// 내 체력 : 35    적 체력 : die
		// 게임 종료~
	}
}