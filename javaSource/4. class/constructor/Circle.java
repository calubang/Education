/*
1. ������ radius
2. ���� : calcArea()
    �ѷ� : calcRound()
// �������� 4�� ���� ���̴� xxx �̰� �ѷ��� xxx �Դϴ�.
// �� ����� ������
*/
public class Circle {
	int radius;
	double pi;
	
	//������
	public Circle(){
		this(4);
	}
	public Circle(int radius){
		if ( checkRadius(radius) )
			this.radius = radius;
		else
			this.radius = 4;
		this.pi = Math.PI;
	}

	// ������ �� Ȯ��
	public boolean checkRadius(int radius){
		if(radius <= 0)
			return false;
		return true;
	}
	
	// ���� ����
	public double calcArea(){
		return  Math.round((double)radius * (double)radius * pi * 100.0)/100.0;
	}

	// ���� �ѷ�
	public double calcRound(){
		return Math.round(2 * pi * (double)radius * 100.0)/100.0;
	}
	
	// info
	// �������� 4�� ���� ���̴� xxx �̰� �ѷ��� xxx �Դϴ�.
	public String info(){
		return "�������� " + radius + "�� ���� ���̴� " + calcArea() + " �̰� �ѷ��� "
				+ calcRound() + " �Դϴ�.";
	}
}
