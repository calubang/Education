public class IfElseIfTest1 {
	public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		
		//y = 5;

		String result = " ����";
		if( x == y ){
			result = " �� ����";
		} else if ( x > y ){
			result += " ũ��";
		} else {
			result += " �۴�";
		}
		
		// �Ϲ������δ� ���� �����ڰ� �ӵ��鿡���� �����ϳ�
		// �������� �˸��̶� �� �Ⱦ��δ�.
		System.out.println(x + " �� " + y + result);
		System.out.println("���α׷� ����");
	}
}
