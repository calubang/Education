public class CarUser {
	public static void main(String[] args) {
		
		//Oracle������ null : �˼�����
		//java������ null : ���� �ȸ������. �����Ҽ� ����.
		Car car1 = null;
		//System.out.println("1. ���̸� : " + car1.carName + "   ���� : " + car1.color + "   ������ : " + car1.maker);
		car1 = new Car();
		System.out.println("1. ���̸� : " + car1.carName + "   ���� : " + car1.color + "   ������ : " + car1.maker);
		car1.carName = "�Ÿ";
		car1.color = "������";
		car1.maker = "����";
		System.out.println("2. ���̸� : " + car1.carName + "   ���� : " + car1.color + "   ������ : " + car1.maker);

		Car car2 = new Car();
		System.out.println("3. ���̸� : " + car2.carName + "   ���� : " + car2.color + "   ������ : " + car2.maker);
		car2.carName = "K5";
		car2.color = "���";
		car2.maker = "���";
		System.out.println("3. ���̸� : " + car2.carName + "   ���� : " + car2.color + "   ������ : " + car2.maker);

		System.out.println("����" + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println("car1�� �ӵ��� 2ȸ ����!!!!");
		car1.speedUp();
		car1.speedUp();
		System.out.println("2ȸ ������" + car1.carName + "�� �ӵ� : " + car1.speed);
		for(int i =0 ; i<8 ; i++){
			car1.speedUp();
		}
		System.out.println("8ȸ ������" + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println("car1�� �ӵ��� 4ȸ ����!!!!");
		for(int i = 0 ; i< 20 ; i++){
			car1.speedDown();
		} 
		System.out.println("4ȸ ������" + car1.carName + "�� �ӵ� : " + car1.speed);
	}
}
