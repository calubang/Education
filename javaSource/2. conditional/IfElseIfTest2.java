/**
score ������ 
	90�̻��̸� ������ A
	80�̻��̸� ������ B
	70�̻��̸� ������ C
	60�̻��̸� ������ D
	60�̸��̸� ������ F

��� : ������ XX���̹Ƿ� x �����Դϴ�.
*/
public class IfElseIfTest2 {
	public static void main(String[] args) {

		// ��������
		int score = 0;
		String grade = "";
		
		//�׽�Ʈ
		score = 75;

		// ���ǹ�
		if ( (score <=100) && (score >= 0) ) {
			//����score
			//System.out.println("����");
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

			// F�� �ƴϰ� 5���̻��̸� + ó��, 100���̻��̾ A+
			if ( score == 100 || ( (score%10) >= 5  && score > 60) ) {
					grade += "+"; 
			}
			System.out.println("������ " + score + " �� �̹Ƿ� " + grade + " ���� �Դϴ�.");
		} else {
			//������ score
			System.out.println("���� is ������");
		}
	}
}