import java.awt.*;
public class IsATest extends Frame {

	Button b = new Button("@눌러바@");

	public IsATest(){
		super("Is A Test 입니다.");
		setLayout(new FlowLayout());
		//b.setLabel("눌러바");
		//f.setTitle();
		add(b);
		setSize(400,300);
		setVisible(true);
		//setLabel("눌러바");
	}
	
	public static void main(String[] args) {

		IsATest iat = new IsATest();
		System.out.println("");
	}
}
