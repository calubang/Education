public class SmartPhoneTest {
	String list;
	
	public SmartPhoneTest(){
		list = "===== �� ǰ �� �� =====\n";
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
		System.out.println("SmartPhoneTest �����մϴ�.");
		
		SmartPhoneTest spt = new SmartPhoneTest();
		SmartPhone galaxyNote2 = new SmartPhone("�Ｚ", "�����ó�Ʈ2"
			, 850000);
		SmartPhone iphone5 = new SmartPhone("����", "������5"
			, 740000, 30);
		SmartPhone galaxyS3 = new SmartPhone("�Ｚ", "������S3"
			, 750000, 35);

		spt.addList(galaxyNote2);
		spt.addList(iphone5);
		spt.addList(galaxyS3);
		
		spt.showList();
	}
}
