package test6;

public class MemberService {
	
	public boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		}	
		return false;
	}
	
	public void logout(String id) {
		System.out.println(id + "님이 로그인 되었습니다.");
	}
	
	public static void main(String[] args) {
		
		Member user1 = new Member("홍길동", "hong");
		Member user2 = new Member("강자바", "java");
		
		System.out.println(user1);
		System.out.println(user2);
		MemberService ms = new MemberService();
		if(ms.login("hong", "12345")) {
			System.out.println("로그인 되었습니다");
			ms.logout("hong");
		}else
			System.out.println("id 또는 password 가 올바르지 않습니다.");
	}
}
