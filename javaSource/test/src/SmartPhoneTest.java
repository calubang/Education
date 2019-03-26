public class SmartPhoneTest {
	String list;
	
	public SmartPhoneTest(){
		list = "===== 제 품 목 록 =====\n";
		list += "------------------------------\n";
	}

	public void addList(SmartPhone sp){
		list += sp;
		list += "------------------------------\n";
	}

	public void showList(){
		System.out.print(list);
	}

	public static void main(String[] args) {
		System.out.println("SmartPhoneTest 시작합니다.");
		
		SmartPhoneTest spt = new SmartPhoneTest();
		SmartPhone galaxyNote2 = new SmartPhone("삼성", "갤럭시노트2"
			, 850000);
		SmartPhone iphone5 = new SmartPhone("애플", "아이폰5"
			, 740000, 30);
		SmartPhone galaxyS3 = new SmartPhone("삼성", "갤럭시S3"
			, 750000, 35);

		spt.addList(galaxyNote2);
		spt.addList(iphone5);
		spt.addList(galaxyS3);
		
		spt.showList();
	}
}
