/*
1. ü�� hp 100, ��� ( 0 : �Ϲݸ��, 1 : ��� )
2. ����() : attack()
	     1ȸ ���ݴ� ��ü�� 0 : -10,   1 : -15
    ��庯��() : changeMode()
	     �� ü�� -25;
		 �� ü�� 40������ ���� ���� �Ұ�.
*/
public class Marine {
	// ü�� hp, ���
	int hp;
	int mode;
	int attackPower;
	String name;

	//������
	public Marine(String name){
		this.hp = 100;
		this.mode = 0;
		this.name = name;
		this.attackPower = 10;
	}
	
	// �����Լ�
	// ���� ap �� �̿��Ͽ� ���� �Ǹ� ��´�.
	public void attack(Marine enemyMarine, int count){
		for ( int i = 0 ; i<count ; i++) {
			if(enemyMarine.decreaseHp(attackPower))
				break;
		}
	}
	
	// �ǰ� ���̴� method
	public boolean decreaseHp(int attackPower){
			hp -= attackPower;
			return checkDeathHp();
	}

	// ���� ���¸� Ȯ���ϴ� method
	public boolean checkDeathHp(){
		if ( hp <= 0 ) {
			hp = 0;
			System.out.println(name + "�� ������ �̸��� ������ �޾Ҵ�!!");
			return true;
		}
		return false;
	}


	// ��庯��
	// 0 �Ϲ�   1 ���
	// 40�̻��̸� ��а���
	// ����ϸ� ü�� -25, ���ݷ� 15�� ����
	public void changeMode(){
		if(mode == 0 && this.hp > 40){
			this.mode = 1;
			attackPower = 15;
			decreaseHp(25);
			System.out.println(name + "�� ������ ���!!!!!");
		} else if (mode == 0 && hp <= 40 ) {
			System.out.println( "���!! "+ name +"�� hp40����!! ������ ��� ���� �����Ͽ����ϴ�.");
		} else if ( mode == 1 ) {
			mode = 0;
			attackPower = 10;
			System.out.println(name + "�� �Ϲ� ���� ���ƿɴϴ�.");
		} else
			System.out.println("����");
	}
	
	// ���� ���� ���¸� ����ִ� method
	public String info(Marine enemyMarine){
		return name + "�� ü�� : " + ((hp == 0) ? "�׾���" : this.hp) + "         " + enemyMarine.name + "�� ü�� : " + ( (hp == 0) ? "�׾���" : enemyMarine.hp) + "\n";
	}
}
