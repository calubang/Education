public class IfElseTest1 {
	public static void main(String[] args) {

		int x = 10;
		int y = 10;
		/*
		if ( x > y ){
			System.out.println(x + "�� " + y + " ���� ũ��");
		} else {
			System.out.println(x + "�� " + y + " ���� �۴�");
		}
		*/
		
		//���ǽĿ����� == != �� ���� ������.
		// �׷��Ƿ� == �񱳸� ���� �ϴ°��� ����
		String result = "����";
		if( x > y ){
			result += "ũ��";
		} else {
			if ( x == y  ){
				result = "�� ����";
			} else {
				result += "�۴�";
			}
		}
		System.out.println(x + "�� " + y + result);
		// ���� ���� IF ~ELSE �ٲ㺸��

		System.out.println("���α׷� ����!!!!");
	}
}