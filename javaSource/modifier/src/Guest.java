public class Guest {
	
	public static int cnt;
	String name;

	public Guest(String name){
		this.name = name;
	}

	public static int visit(){
		cnt++;
		return cnt;
	}
}
