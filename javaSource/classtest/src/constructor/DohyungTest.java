package constructor;
public class DohyungTest{
	
	public static void main(String[] args) {
		// default �簢���� ����4 ����3 
		// ���ΰ� 4�̰� ���ΰ� 3�� ������� ���̴� 12�̰� �ѷ��� 14�Դϴ�.
		Rect r1 = new Rect();
		System.out.println(r1.calcRound() + "   "  + r1.calcArea());
		
		System.out.println(r1.info());

		// �� ����� ���� ���� ���ϱ�
		Rect r2 = new Rect(7, 9);
		System.out.println(r2.info());
		
		// default ���� ������4
		// �������� 4�� ���� ���̴� xxx �̰� �ѷ��� xxx �Դϴ�.
		Circle c1 = new Circle();
		System.out.println(c1.info());
		// �� ����� ������
		Circle c2 = new Circle(-3);
		System.out.println(c2.info());
	}
}