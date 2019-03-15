/*
score 가 90이상이면 학점은 A
             80이상이면 학점은 B
			 70이상이면 학점은 C
			 60이상이면 학점은 D
			 60미만은 학점은 F
X5 이상이면 X+ 학점

결과 : 점수가 XX점이므로 X학점입니다.
*/
public class SwitchTest2 {
	public static void main(String[] args) {
		
		String grade = "";
		int score = 110;
		
		switch ( score / 10 ) {
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default :
				grade = "F";
				break;
		}
		if ( score == 100 || ((score % 10 >= 5) && score >60)  ) {
			grade += "+";
		}

		System.out.println("점수가 " + score + "점이므로 " + grade + " 학점 입니다");
	}
}
