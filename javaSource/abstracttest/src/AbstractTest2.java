import java.awt.*;
import java.awt.event.*;
public class AbstractTest2 extends Frame {

	Button b = new Button("@������@");

	public AbstractTest2(){
		super("Is A Test �Դϴ�.");
		setLayout(new FlowLayout());
		//b.setLabel("������");
		//f.setTitle();
		add(b);
		setSize(400,300);
		setVisible(true);
		//setLabel("������");
		
		WindowListener wl = new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
			@Override
			public void windowIconified(WindowEvent e){
				System.out.println("������ȭ");
			}
		};
		addWindowListener(wl);
	}
	
	public static void main(String[] args) {

		AbstractTest2 iat = new AbstractTest2();
		System.out.println("");
	}
}