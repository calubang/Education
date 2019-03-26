package test6;

public class ShopService {
	
	private static ShopService shopService = new ShopService();
	
	private ShopService() {}
	
	public static ShopService getInstance() {
		return shopService;
	}
	
	public static void main(String[] args) {
		
		ShopService ss1 = ShopService.getInstance();
		ShopService ss2 = ShopService.getInstance();
		
		if(ss1 ==  ss2)
			System.out.println("둘은 같은 객체입니다.");
		else
			System.out.println("둘은 다른 객체입니다.");
	}

}
