public class BookOrderTest {
	String order;
	int totalPrice;
	
	public BookOrderTest(){
		order = "===== ���� ���� ��� =====\n";
	}

	public int calcPrice(int discount){
		return (int)Math.round(totalPrice * (1- discount/100.0));
	}

	public void addBook(Book book){
		order += book + "\n";
		totalPrice += book.price;
	}

	public void orderClose(int discount){
		order += "----------------------------------\n";
		order += "�ֹ� �ѱݾ�  :  " + totalPrice + "��\n";
		order += "������ ���� �ݾ�  :  " + calcPrice(discount) + "��\n";
	}

	public void showOrder(){
		System.out.print(order);
	}

	public static void main(String[] args) {
		
		System.out.println("BookOrderTest----------------------");
		BookOrderTest bookOrder = new BookOrderTest();
		Book java = new Book("java", 24000);
		Book jquery = new Book("JQuery", 21000);
		Book oracle = new Book("����Ŭ", 19000);
		Book spring = new Book("������", 35000);

		bookOrder.addBook(java);
		bookOrder.addBook(jquery);
		bookOrder.addBook(oracle);
		bookOrder.addBook(spring);
		bookOrder.orderClose(15);
		bookOrder.showOrder();
	}
}
