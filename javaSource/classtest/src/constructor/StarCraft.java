package constructor;
public class StarCraft {
	public static void main(String[] args) {
		//����
		Marine my = new Marine("��");   // �� ����
		Marine com = new Marine("��ǻ��");   // ��ǻ�� ����
		
		// ����ȭ��
		// �� ü�� : 100
		// �� ü�� : 100
		int count = 2;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		my.attack(com, count);
		System.out.println(my.info(com));
	
		// �� ü�� : 100    �� ü�� : 80
		count = 4;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		com.attack(my, count);
		System.out.println(my.info(com));
		// �� ü�� : 60     �� ü�� : 80

		System.out.println("��� ����!!!");
		my.changeMode();
		System.out.println(my.info(com));
		// �� ü�� : 35     �� ü�� : 80
		count = 3;
		System.out.println("���� ���� "+count+"ȸ ����!!!!");
		my.attack(com, count);
		System.out.println(my.info(com));
		// �� ü�� : 35     �� ü�� : 35

		System.out.println("��� ����!!!");
		my.changeMode();
		System.out.println(my.info(com));
		// ��� : ��� ���� �Ұ�~!!!!!
		
		System.out.println("��� ����!!!");
		my.changeMode();
		System.out.println(my.info(com));
		// ��� : ��� ���� �Ұ�~!!!!!

		count = 4;
		System.out.println("���� ���� " + count + " ȸ ����!!!!");
		my.attack(com, count);
		System.out.println(my.info(com));
		// �� ü�� : 35    �� ü�� : die
		// ���� ����~
	}
}