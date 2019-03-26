import java.awt.*;
import java.awt.event.*;
public class InterfaceTest extends Frame implements WindowListener, ActionListener {

	Button b = new Button("@눌러바@");

	public InterfaceTest(){
		super("Is A Test 입니다.");
		setLayout(new FlowLayout());
		//b.setLabel("눌러바");
		//f.setTitle();
		add(b);
		setSize(400,300);
		setVisible(true);
		//setLabel("눌러바");

		//WindowListener wl = new WindowListener();
		WindowListener wl2 = new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			
			}
		};

		addWindowListener(this);
		b.addActionListener(this);
	}
	//addActionListener
	public void actionPerformed(ActionEvent e){
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		setBackground(new Color(r, g, b));
	}
	
	//addWindowListener
	public void windowActivated(WindowEvent e){
		
	}
	public void windowClosed(WindowEvent e){
	
	}
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e){
	
	}
	public void windowDeiconified(WindowEvent e){
	
	}
	public void windowIconified(WindowEvent e){
	
	}
	public void windowOpened(WindowEvent e){
	
	}

	public static void main(String[] args) {

		InterfaceTest iat = new InterfaceTest();
		System.out.println("");
	}
}
