import java.io.*;
public class RockScissorsPaper {
	private int com;
	BufferedReader in;

	public RockScissorsPaper(){
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// ��ǻ�� ������ ����
	private void comRandom(){
		com = (int)(Math.random() * 3);
	}
	// ������ gbb�� �ѱ۷� ��ȯ
	private String getGBB(int gbb){
		switch ( gbb ) {
			case 0:
				return "����";
			case 1:
				return "����";
			case 2:
				return "��";
			default:
				return "����";
		}
	}
	// ���ӽ���
	// ���ų� ���� �̱涧���� �ؾ��Ѵ�.
	public void gameStart() throws Exception {
		int my = 0;
		while(true){
			System.out.print("����(0), ����(1), ��(2) �����ϼ���. : ");
			my = Integer.parseInt(in.readLine());
			if ( my >= 0 && my <3 ) {
				if ( game(my) == 1 )
					menu();
			} else
				System.out.println("0-2�� �ϳ��� �Է� �����մϴ�.");
		}
	}
	// ���Ӱ��
	private int game(int my) throws Exception{
		comRandom();
		String resultStr = "";
		int result = (my-com + 3) % 3;
		switch ( result ) {
			case 0:
				resultStr = "����";
				break;
			case 1:
				resultStr = "�̰��";
				break;
			case 2:
				resultStr = "����";
				break;
			default:
				resultStr = "����";
		}
		System.out.println("�� : " + getGBB(my) + "         ��ǻ�� : " 
				+ getGBB(com) + "         ����� : " + resultStr);
		return result;
	}
	// �޴��� ȣ��
	private void menu() throws Exception {
		int menu;
		while(true){
			System.out.print("���� ���(1), ����(0)�� �Է��ϼ��� : ");
			menu = Integer.parseInt(in.readLine());
			if ( menu == 0 ) {
				exit();
			} else if ( menu == 1 ) {
				//�������
				break;
			} else
				System.out.println("0, 1�� �ϳ��� �Է� �����մϴ�.");
		}
	}
	//���α׷� ����
	private void exit(){
		System.out.println("���α׷� �����մϴ�.!!!");
		System.exit(0);
	}
	
	public static void main(String[] args) throws Exception {
		RockScissorsPaper rsp = new RockScissorsPaper();
		System.out.println("==== ��ǻ�Ϳ� ���������� ����!!! ====");
		rsp.gameStart();
	}
}
