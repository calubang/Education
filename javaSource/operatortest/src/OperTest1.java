public class OperTest1 {
	public static void main(String[] args) {
		// ���� ������
		int x = 10;
		System.out.println(x);
		System.out.println(x++ + "     " + x);
		System.out.println(--x + "     " + x);
		System.out.println(x++ + "     " + x);
		System.out.println(++x + "     " + x);
		System.out.println(x-- + "     " + x);
		System.out.println(--x + "     " + x);
		System.out.println(x++ + "     " + x);
		System.out.println(x);

		char c = 'a';
		System.out.println("c == " + c);
		// ���� ����ȯ (data type)������
		System.out.println("(int)c == " + (int) c);

		// �ڵ�����ȯ
		// �������� ū�������� �ִ°��� ����
		int y = c;
		System.out.println("y == " + y);

		// int(4byte) �� char (2byte) �ȿ� ���� �� ��� �����߻�
		// ��������ȯ
		c = (char) y;
		System.out.println("c == " + c);

		// Ÿ�Ժ�ȯ�� ������ �͸� ����
		// boolean b = true;
		// int z = b;

		boolean b = true;
		//z = (int) b;
	}
}
