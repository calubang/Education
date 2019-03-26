package test6;

public class PrintExample {
	
	public static void main(String[] args) {
		Printer p = new Printer();
		
		p.println(10);
		p.println(true);
		p.println(5.7);
		p.println("ȫ�浿");
		
		Printer.println(11);
		Printer.println(false);
		Printer.println(6.7);
		Printer.println("ȫ�浿2");
	}
	
}
