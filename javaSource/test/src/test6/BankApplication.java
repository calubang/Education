package test6;

import java.util.Scanner;
enum menuKinds{
	CREATE, VIEW, DEPOSIT, WITHDRAW, EXIT
}

public class BankApplication {
	
	private static Account[] accountArray = new Account[100];
	private Scanner scanner = new Scanner(System.in);
		
	public void menu() {
		int menu = 0;
		while(menu != 5) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("-------------------------------------------------------");
			System.out.println("����> ");
			menu = scanner.nextInt();
			
			switch (menu) {
			case 1:
				createAccount();
				break;
			case 2:
				accountList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();

			default:
				break;
			}
		}
	}
	//create
	public void createAccount() {
		System.out.println("--------------");
		System.out.println("���»���");
		System.out.println("--------------");
		System.out.println("���¹�ȣ : ");
		
		System.out.println("��ݾ� : ");
	}
	public void accountList() {
		
	}
	public void deposit() {
		
	}
	public void withdraw() {
		
	}
	
	private static Account findAccount(String accountNumber) {
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
