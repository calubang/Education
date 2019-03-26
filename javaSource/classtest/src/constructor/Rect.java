package constructor;
/*
1. ���� width, ���� height
2. ���� : calcArea()
    �ѷ� : calcRound()
// default �簢���� ����4 ����3 
// ���ΰ� 4�̰� ���ΰ� 3�� ������� ���̴� 12�̰� �ѷ��� 14�Դϴ�
// �� ����� ���� ���� ���ϱ�
*/
public class Rect {
	int width;
	int height;

	//������
	public Rect(){
		this(4, 3);	
	}
	public Rect(int width){
		this(width, 3);
	}
	/*
	public Rect(int height){
		this(4, height);
	}
	*/
	public Rect(int width, int height){
		if ( checkValue(width) )
			this.width = width;
		else
			this.width = 4;

		if ( checkValue(height) )
			this.height = height;
		else
			this.height = 3;
	}

	// ���� �ùٸ� ������ Ȯ��
	public boolean checkValue(int value){
		if(value <= 0)
			return false;
		return true;
	}

	// ���̱��ϱ�
	public int calcArea(){
		return this.width * this.height;
	}

	// �ѷ����ϱ�
	public int calcRound(){
		return (this.width + this.height) * 2;
	}

	// info
	// ���ΰ� 4�̰� ���ΰ� 3�� ������� ���̴� 12�̰� �ѷ��� 14�Դϴ�
	public String info(){
		return "���ΰ� " + width + "�̰� ���ΰ� " + height + "�� ������� ���̴� "
				+ calcArea() + "�̰� �ѷ��� " + calcRound() + " �Դϴ�.";
	}
}
