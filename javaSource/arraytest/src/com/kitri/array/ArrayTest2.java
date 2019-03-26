package com.kitri.array;

public class ArrayTest2 {
	
	public static void main(String[] args) {
		
		Car[] car = new Car[6];
		car[0] = new Car("쏘나타1", "검정색1", "현대1");
		car[1] = new Car("쏘나타2", "검정색2", "현대2");
		car[2] = new Car("쏘나타3", "검정색3", "현대3");
		car[3] = new Car("쏘나타4", "검정색4", "현대4");
		car[4] = new Car("니어로", "비둘기", "구리구리");
		car[5] = new Car("싼타페", "회색", "cu");
		
		System.out.println(car[0].getCarName());
		
		for(int i = 0 ; i<car.length ; i++) {
			System.out.println("[" + i + "] : " + car[i]);
		}
		
		
		String name = "니어로";
		name = "QM5";
		Car temp = null;
		int number = 0;
		
		for(int i = 0 ; i < car.length ; i++) {
			if(car[i].getCarName().equals(name) ) {
				temp = car[i];
				number = i+1;
				break;
			}
		}
		
		if(temp != null) {
			System.out.println(temp.getColor() +"색 " 
					+ temp.getCarName() + "(" + temp.getMaker() +  ")는 " + number + "번째에 있습니다." );
		} else{
			System.out.println(name + "는 없습니다.");
		}
	}
}
