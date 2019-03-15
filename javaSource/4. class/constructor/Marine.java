/*
1. 체력 hp 100, 모드 ( 0 : 일반모드, 1 : 흥분 )
2. 공격() : attack()
	     1회 공격당 적체력 0 : -10,   1 : -15
    모드변경() : changeMode()
	     내 체력 -25;
		 내 체력 40이하일 경우는 변경 불가.
*/
public class Marine {
	// 체력 hp, 모드
	int hp;
	int mode;
	int attackPower;
	String name;

	//생성자
	public Marine(String name){
		this.hp = 100;
		this.mode = 0;
		this.name = name;
		this.attackPower = 10;
	}
	
	// 공격함수
	// 나의 ap 를 이용하여 적의 피를 깍는다.
	public void attack(Marine enemyMarine, int count){
		for ( int i = 0 ; i<count ; i++) {
			if(enemyMarine.decreaseHp(attackPower))
				break;
		}
	}
	
	// 피가 깍이는 method
	public boolean decreaseHp(int attackPower){
			hp -= attackPower;
			return checkDeathHp();
	}

	// 나의 상태를 확인하는 method
	public boolean checkDeathHp(){
		if ( hp <= 0 ) {
			hp = 0;
			System.out.println(name + "가 죽음에 이르는 공격을 받았다!!");
			return true;
		}
		return false;
	}


	// 모드변경
	// 0 일반   1 흥분
	// 40이상이면 흥분가능
	// 흥분하면 체력 -25, 공격력 15로 증가
	public void changeMode(){
		if(mode == 0 && this.hp > 40){
			this.mode = 1;
			attackPower = 15;
			decreaseHp(25);
			System.out.println(name + "는 스팀팩 모드!!!!!");
		} else if (mode == 0 && hp <= 40 ) {
			System.out.println( "경고!! "+ name +"의 hp40이하!! 스팀팩 모드 변경 실패하였습니다.");
		} else if ( mode == 1 ) {
			mode = 0;
			attackPower = 10;
			System.out.println(name + "가 일반 모드로 돌아옵니다.");
		} else
			System.out.println("오류");
	}
	
	// 나와 적의 상태를 찍어주는 method
	public String info(Marine enemyMarine){
		return name + "의 체력 : " + ((hp == 0) ? "죽었다" : this.hp) + "         " + enemyMarine.name + "의 체력 : " + ( (hp == 0) ? "죽었다" : enemyMarine.hp) + "\n";
	}
}
