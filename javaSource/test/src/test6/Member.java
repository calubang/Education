package test6;

public class Member {
	public String name;
	public String id;
	public String password;
	public int age;
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", password=" + password + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		Member user2 = new Member("강자바", "java");
		
		System.out.println(user1);
		System.out.println(user2);
	}
}
