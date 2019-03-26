import java.io.*;
public class RockScissorsPaper {
	private int com;
	BufferedReader in;

	public RockScissorsPaper(){
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// 컴퓨터 랜덤값 지정
	private void comRandom(){
		com = (int)(Math.random() * 3);
	}
	// 숫자인 gbb를 한글로 변환
	private String getGBB(int gbb){
		switch ( gbb ) {
			case 0:
				return "가위";
			case 1:
				return "바위";
			case 2:
				return "보";
			default:
				return "오류";
		}
	}
	// 게임시작
	// 지거나 비기면 이길때까지 해야한다.
	public void gameStart() throws Exception {
		int my = 0;
		while(true){
			System.out.print("가위(0), 바위(1), 보(2) 선택하세요. : ");
			my = Integer.parseInt(in.readLine());
			if ( my >= 0 && my <3 ) {
				if ( game(my) == 1 )
					menu();
			} else
				System.out.println("0-2중 하나만 입력 가능합니다.");
		}
	}
	// 게임결과
	private int game(int my) throws Exception{
		comRandom();
		String resultStr = "";
		int result = (my-com + 3) % 3;
		switch ( result ) {
			case 0:
				resultStr = "비겼다";
				break;
			case 1:
				resultStr = "이겼다";
				break;
			case 2:
				resultStr = "졌다";
				break;
			default:
				resultStr = "오류";
		}
		System.out.println("나 : " + getGBB(my) + "         컴퓨터 : " 
				+ getGBB(com) + "         결과는 : " + resultStr);
		return result;
	}
	// 메뉴를 호출
	private void menu() throws Exception {
		int menu;
		while(true){
			System.out.print("게임 계속(1), 종료(0)을 입력하세요 : ");
			menu = Integer.parseInt(in.readLine());
			if ( menu == 0 ) {
				exit();
			} else if ( menu == 1 ) {
				//계속진행
				break;
			} else
				System.out.println("0, 1중 하나만 입력 가능합니다.");
		}
	}
	//프로그램 종료
	private void exit(){
		System.out.println("프로그램 종료합니다.!!!");
		System.exit(0);
	}
	
	public static void main(String[] args) throws Exception {
		RockScissorsPaper rsp = new RockScissorsPaper();
		System.out.println("==== 컴퓨터와 가위바위보 한판!!! ====");
		rsp.gameStart();
	}
}
