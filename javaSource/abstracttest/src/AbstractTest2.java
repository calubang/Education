import java.awt.*;
import java.awt.event.*;
public class AbstractTest2 extends Frame {

	Button b = new Button("@눌러바@");

	public AbstractTest2(){
		super("Is A Test 입니다.");
		setLayout(new FlowLayout());
		//b.setLabel("눌러바");
		//f.setTitle();
		add(b);
		setSize(400,300);
		setVisible(true);
		//setLabel("눌러바");
		
		WindowListener wl = new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			@Override
			public void windowIconified(WindowEvent e){
				System.out.println("아이콘화");
			}
		};
		addWindowListener(wl);
	}
	
	public static void main(String[] args) {

		AbstractTest2 iat = new AbstractTest2();
		System.out.println("");
	}
}