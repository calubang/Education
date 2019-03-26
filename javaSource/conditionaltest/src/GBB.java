/*
시나리오 
** 가위 바위 보
1. 0 가위, 1바위 2보
    0 가위  1바위 2보




	숫자가 같으면 비김
	숫자가 다르다 이기거나 짐
	나 - 컴퓨터 0이면 비긴다
	나 - 컴퓨터가 -2면 이김
                         -1면 짐
						 1     이김
						 -1   짐
						 2    짐
						 1 이면 이김
		-2, 1 이김
		-1, 2 짐
2. 컴퓨터는 난수발생(0, 1, 2)
3. 내가 내고 싶은 것은 코드상으로 표현
4. 결과 logic 이기거나 지거나 비기거나
5. 결과 출력
	나 : x, 컴 : x  결과 : (이겼다, 비겼다, 졌다.)
*/
public class GBB {
	public static void main(String[] args) {
		
		//변수
		double randomValue = Math.random();
		int computer = (int)(randomValue*3);
		int me = 1;
		
		int result = -3;
		String resultStr = "";
		String meGBB = "";
		String comGBB = "";

		// 결과
		result = me - computer;
		result = (result+3) % 3;

		switch ( result ) {
			case 0:
				resultStr = "비겼다.";
				break;
			case 1:
				resultStr = "이겼다!!!";
				break;
			case 2:
				resultStr = "졌다..";
				break;
			default :
				resultStr = "오류";
				break;
		}
		
		// 0 : 가위  1 바위  2 보
		switch ( me ) {
			case 0:
				meGBB = "가위";
				break;
			case 1:
				meGBB = "바위";
				break;
			case 2:
				meGBB = "보";
				break;
			default :
				meGBB = "오류";
				break;
		}
		switch ( computer ) {
			case 0:
				comGBB = "가위";
				break;
			case 1:
				comGBB = "바위";
				break;
			case 2:
				comGBB = "보";
				break;
			default :
				comGBB = "오류";
				break;
		}

		System.out.println("나        : " + meGBB + me + "\n컴퓨터 : " + comGBB + computer + "\n결과 : " + resultStr);
	
	}
}
