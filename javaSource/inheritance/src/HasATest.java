import java.awt.*;
public class HasATest {

	Frame f = new Frame("Has A Test");
	Button b = new Button("@������@");

	public HasATest(){
		f.setLayout(new FlowLayout());
		//b.setLabel("������");
		//f.setTitle();
		f.add(b);
		f.setSize(400,300);
		f.setVisible(true);
		b.setLabel("������");
	}

	public static void main(String[] args) {
		
		HasATest hat = new HasATest();
		System.out.println("");
	}
}
