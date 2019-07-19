import com.kitri.dto.Test;
import com.kitri.dto.TestImpl;

public class LamdaTest {
	public static void test(Test t) {
		t.m(10);
	}
	
	public static void main(String[] args) {
//		TestImpl impl = new TestImpl();
//		impl.m(10);
//		TestImpl impl = new TestImpl();
//		test(impl);
		
		//람다표현식으로 
		//i->System.out.println(i);
		test(a->System.out.println(a));
		
		
	}
}
