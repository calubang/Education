public class BusGuest {
	int age;

	public BusGuest(int age){
		this.age = age;
	}

	public String getAge(){
		if(age > 19)
			return "성인";
		else if ( age >10 ) 
			return "청소년";
		else
			return "어린이";
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
		
		//내린다.
		bus.takeOff();
		bus.info();
		bus.takeOff();
		bus.info();
		bus.takeOff();
		bus.info();
		bus.takeOff();
		bus.info();

		//탔다 내렸다
		bus.takeOn(guest1);
		bus.info();
		bus.takeOff();
		bus.info();
		bus.takeOn(guest3);
		bus.info();

		//영업종료
		bus.finish();
	}
}
