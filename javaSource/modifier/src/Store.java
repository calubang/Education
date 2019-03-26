public class Store {
	
	int cnt;

	public void visit(){
		cnt++;
	}

	public static void main(String[] args) {
		PointCard p1 = new PointCard("박미래");
		PointCard p2 = new PointCard("황선혜");
		
		int point = p1.visit();
		System.out.println(p1.name + "님의 포인트는 " + point + "입니다.");

		point = p2.visit();
		System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");

		point = p2.visit();
		System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");

		Guest g1 = new Guest("박미래");
		Guest g2 = new Guest("황선혜");
		System.out.println(g1.name + "님 방문입니다.");
		int count = g1.visit();
		System.out.println(g1.name + "님은 " + count + "번째 방문객입니다.");
		
		System.out.println(g2.name + "님 방문입니다.");
		count = g2.visit();
		System.out.println(g2.name + "님은 " + count + "번째 방문객입니다.");

		System.out.println(g1.name + "님 방문입니다.");
		count = g1.visit();
		System.out.println(g1.name + "님은 " + count + "번째 방문객입니다.");
		
	}
}
