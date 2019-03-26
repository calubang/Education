/**
score 점수가 
	90이상이면 학점은 A
	80이상이면 학점은 B
	70이상이면 학점은 C
	60이상이면 학점은 D
	60미만이면 학점은 F

결과 : 점수가 XX점이므로 x 학점입니다.
*/
public class IfElseIfTest2 {
	public static void main(String[] args) {

		// 변수선언
		int score = 0;
		String grade = "";
		
		//테스트
		score = 75;

		// 조건문
		if ( (score <=100) && (score >= 0) ) {
			//정상score
			//System.out.println("정상");
			if ( score >= 90 ){
				grade = "A";
			} else if (score >= 80){
				grade = "B";
			} else if ( score >= 70 ){
				grade = "C";
			} else if ( score >= 60 ) {
				grade = "D";
			} else {
				grade = "F";
			}

			// F가 아니고 5점이상이면 + 처리, 100점이상이어도 A+
			if ( score == 100 || ( (score%10) >= 5  && score > 60) ) {
					grade += "+"; 
			}
			System.out.println("점수가 " + score + " 점 이므로 " + grade + " 학점 입니다.");
		} else {
			//비정상 score
			System.out.println("점수 is 비정상");
		}
	}
}