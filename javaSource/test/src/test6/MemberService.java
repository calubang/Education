package test6;

public class MemberService {
	
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}	
		return false;
	}
	
	public void logout(String id) {
		System.out.println(id + "���� �α��� �Ǿ����ϴ�.");
	}
	
	public static void main(String[] args) {
		
		Member user1 = new Member("ȫ�浿", "hong");
		Member user2 = new Member("���ڹ�", "java");
		
		System.out.println(user1);
		System.out.println(user2);
		MemberService ms = new MemberService();
		if(ms.login("hong", "12345")) {
			System.out.println("�α��� �Ǿ����ϴ�");
			ms.logout("hong");
		}else
			System.out.println("id �Ǵ� password �� �ùٸ��� �ʽ��ϴ�.");
	}
}
