/*
�ó����� 
** ���� ���� ��
1. 0 ����, 1���� 2��
    0 ����  1���� 2��




	���ڰ� ������ ���
	���ڰ� �ٸ��� �̱�ų� ��
	�� - ��ǻ�� 0�̸� ����
	�� - ��ǻ�Ͱ� -2�� �̱�
                         -1�� ��
						 1     �̱�
						 -1   ��
						 2    ��
						 1 �̸� �̱�
		-2, 1 �̱�
		-1, 2 ��
2. ��ǻ�ʹ� �����߻�(0, 1, 2)
3. ���� ���� ���� ���� �ڵ������ ǥ��
4. ��� logic �̱�ų� ���ų� ���ų�
5. ��� ���
	�� : x, �� : x  ��� : (�̰��, ����, ����.)
*/
public class GBB {
	public static void main(String[] args) {
		
		//����
		double randomValue = Math.random();
		int computer = (int)(randomValue*3);
		int me = 1;
		
		int result = -3;
		String resultStr = "";
		String meGBB = "";
		String comGBB = "";

		// ���
		result = me - computer;
		result = (result+3) % 3;

		switch ( result ) {
			case 0:
				resultStr = "����.";
				break;
			case 1:
				resultStr = "�̰��!!!";
				break;
			case 2:
				resultStr = "����..";
				break;
			default :
				resultStr = "����";
				break;
		}
		
		// 0 : ����  1 ����  2 ��
		switch ( me ) {
			case 0:
				meGBB = "����";
				break;
			case 1:
				meGBB = "����";
				break;
			case 2:
				meGBB = "��";
				break;
			default :
				meGBB = "����";
				break;
		}
		switch ( computer ) {
			case 0:
				comGBB = "����";
				break;
			case 1:
				comGBB = "����";
				break;
			case 2:
				comGBB = "��";
				break;
			default :
				comGBB = "����";
				break;
		}

		System.out.println("��        : " + meGBB + me + "\n��ǻ�� : " + comGBB + computer + "\n��� : " + resultStr);
	
	}
}
