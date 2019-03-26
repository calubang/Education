public class Book {
	String name;
	int price;

	public Book(String name, int price){
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString(){
		return name + "  :  " + price;
	}
}
