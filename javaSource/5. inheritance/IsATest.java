import java.awt.*;
public class IsATest extends Frame {

	Button b = new Button("@������@");

	public IsATest(){
		super("Is A Test �Դϴ�.");
		setLayout(new FlowLayout());
		//b.setLabel("������");
		//f.setTitle();
		add(b);
		setSize(400,300);
		setVisible(true);
		//setLabel("������");
	}
	
	public static void main(String[] args) {

		IsATest iat = new IsATest();
		System.out.println("");
	}
}
