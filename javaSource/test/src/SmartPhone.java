public class SmartPhone {
	private String maker;
	private String name;
	private int price;
	private int discountRate;

	public SmartPhone(String maker, String name, int price){
		this(maker, name, price, 0);
	}
	public SmartPhone(String maker, String name, 
		int price, int discountRate){
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}
	public int calculateDiscount(){
		return (int)Math.round(price * (1-discountRate/100.0)); 
	}

	@Override
	public String toString(){
		String info = "";
		if ( discountRate == 0 )
			return name + " [" + maker + "]\n가격  :  " + price + "\n";
		 return name + " [" + maker + "]\n가격  :  " 
			 + price + "\n할인가격  :  " + calculateDiscount() + "\n";
	}
}
