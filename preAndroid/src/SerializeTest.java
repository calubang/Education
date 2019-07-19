import java.io.*;
import java.util.Date;

import com.kitri.dto.Child;
import com.kitri.dto.Product;

public class SerializeTest {
	
	public static void main(String[] args) {
		/*
		 * file-name : a.ser
		 * 바이트단위 출력스트림 : FileOutputStream
		 * 객체출력 스트림 : ObjectOutputStream
		 */
		ObjectOutputStream oos = null;
		System.out.println("test 시작");
		try {
			oos = new ObjectOutputStream(new FileOutputStream("a.ser"));
			Date now = new Date();
			Product product = new Product();
			product.setProd_no("001");
			product.setProd_name("아메리카노");
			product.setProd_price(2500);
			
			Child c = new Child();
			c.setC("Child Instance Variable");
					
			oos.writeObject(now);
			oos.writeObject(product);
			oos.writeObject(c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		/*
		 * file-name : a.ser
		 * ByteInputStream : fileInputStream
		 * ObjectInputStream
		 */
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("a.ser"));
			Object obj = ois.readObject();
			System.out.println(obj);
			
			obj = ois.readObject();
			System.out.println(obj);
			
			obj = ois.readObject();
			Child c1 = (Child)obj;
			System.out.println("c : " + c1.getC());
			System.out.println("p : " + c1.getP());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
