/*
Lotto
1 - 3 ������ ���� �ٸ� ���� 3�� �߻�

*/

public class ForLotto {
	public static void main(String[] args) {
		
		//���� ���� ����
		//int num1, num2, num3;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		// num1 �Ҵ�
		num1 = (int)(Math.random()*3) + 1;
		for ( ; ; ) {
			num2 = (int)(Math.random()*3) + 1;
			if ( num1 != num2 ) {
				for( ; ; ){
					num3 = (int)(Math.random()*3) + 1;
					if( (num1 != num3) && (num2 != num3) ) {
						break;
					}
				}
				break;
			}
		}

		System.out.println("Lotto ��ȣ�� " + num1 + "   " + num2 + "   " + num3);
		System.out.println("���α׷� ����!!");
	}
}
