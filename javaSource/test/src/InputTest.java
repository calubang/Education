import java.io.*;
public class InputTest {

	BufferedReader in;

	public InputTest(){
		
	}
	public void game() throws Exception{
		System.out.print("0 1 2 ют╥б : ");
		int my = Integer.parseInt(in.readLine());
		System.out.println("my === " + my);
	}

	public static void main(String[] args) throws Exception {
		
		InputTest t = new InputTest();
		t.game();
		//System.out.println("");
	}
}
