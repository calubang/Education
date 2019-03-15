public class BusGuest {
	int age;

	public BusGuest(int age){
		this.age = age;
	}

	public String getAge(){
		if(age > 19)
			return "����";
		else if ( age >10 ) 
			return "û�ҳ�";
		else
			return "���";
	}

	public static void main(String[] args) {
		
		int number = 4;
		BusGuest guest1 = new BusGuest(7);
		BusGuest guest2 = new BusGuest(15);
		BusGuest guest3 = new BusGuest(20);
		BusGuest guest4 = new BusGuest(30);
		Bus bus = new Bus(12);

		bus.init();
		bus.takeOn(guest1);
		bus.info();
		bus.takeOn(guest2);
		bus.info();
		bus.takeOn(guest3);
		bus.info();
		bus.takeOn(guest4);
		bus.info();
		
		//������.
		bus.takeOff();
		bus.info();
		bus.takeOff();
		bus.info();
		bus.takeOff();
		bus.info();
		bus.takeOff();
		bus.info();

		//���� ���ȴ�
		bus.takeOn(guest1);
		bus.info();
		bus.takeOff();
		bus.info();
		bus.takeOn(guest3);
		bus.info();

		//��������
		bus.finish();
	}
}
