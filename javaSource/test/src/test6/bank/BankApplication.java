package test6.bank;

import java.util.Scanner;

import com.sun.glass.ui.Menu;

public class BankApplication {
	
	Account accountArray[] = new Account[500];
	Scanner scan = new Scanner(System.in);
	String input = "";
	
	public void menu() {
		int menu = 0;
		
		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1. 계좌생성  |  2. 계좌목록  |  3. 예금  |  4. 출금  |  5. 종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 : ");
			input = scan.nextLine();
			if(!checkNumber(input)) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			menu = Integer.parseInt(input);
			switch (menu) {
			case 1:
				createAccount();
				break;
			case 2:
				viewAccountArray();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}while(menu != 5);	
	}
	
	private boolean checkNumber(String input) {
		input = input.trim();
		for(int i =0 ; i < input.length() ; i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	private void withdraw() {
		Account account = null;
		String number = "";
		int withdrawAmount = 0;
		
		System.out.println("------------------------");
		System.out.println("출금");
		System.out.println("------------------------");
		System.out.print("계좌번호 : ");
		number = scan.nextLine();
		account = findAccount(number);
		if(account != null) {
			System.out.print("출금액 : ");
			withdrawAmount = Integer.parseInt(scan.nextLine());			
			if(account.withdrawAccount(withdrawAmount) >= 0) {
				System.out.println("결과 : 출금이 성공되었습니다.");
				System.out.println(account);
			}
		} else {
			System.out.println("올바르지 않은 계좌번호입니다.");
		}
	}

	private void deposit() {
		Account account = null;
		String number = "";
		int depositAmount = 0;
		
		System.out.println("------------------------");
		System.out.println("입금");
		System.out.println("------------------------");
		System.out.print("계좌번호 : ");
		number = scan.nextLine();
		account = findAccount(number);
		if(account != null) {
			System.out.print("예금액 : ");
			depositAmount = Integer.parseInt(scan.nextLine());
			account.depositAccount(depositAmount);
			System.out.println("결과 : 예금이 성공되었습니다.");
			System.out.println(account);
		} else {
			System.out.println("올바르지 않은 계좌번호입니다.");
		}
	}
	
	private Account findAccount(String number) {
		Account account = null;
		for(int i = 0; i<accountArray.length ; i++) {
			account = accountArray[i];
			if(account != null) {
				if(account.getnumber().equals(number)) {
					return account;
				}
			}
		}
		return account;
	}

	private void viewAccountArray() {
		Account account = null;
		System.out.println("------------------------");
		System.out.println("계좌목록");
		System.out.println("------------------------");
		
		for(int i = 0; i<accountArray.length ; i++) {
			account = accountArray[i];
			if(account != null) {
				System.out.println(account.getnumber() + "\t" +account.getName() + "\t" + account.getBalance());
			} else {
				break;
			}
		}
	}
	

	private void createAccount() {
		String name = null;
		int balance = 0;
		int arrayIndex = 0;
		
		System.out.println("------------------------");
		System.out.println("계좌생성");
		System.out.println("------------------------");
		System.out.print("예금주 : ");
		name = scan.nextLine();
		System.out.print("초기예금금액 : ");
		balance = Integer.parseInt(scan.nextLine());
		Account account = new Account(name, balance);
		arrayIndex = emptyAccountArray();
		accountArray[arrayIndex] = account;
		System.out.println("결과 : 계좌가 생성되었습니다.");
		System.out.println(account);
	}
	
	private int emptyAccountArray() {
		for(int i = 0; i < accountArray.length ; i++) {
			if(accountArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 계좌생성 2. 계좌목록  3. 예금  4. 출금  5. 종료
		
		
		Account account1 = new Account("안병욱", 100000);
		Account account2 = new Account("이재운", 10000);
		
		
		//System.out.println(account1);
		//System.out.println(account2);
		BankApplication ba = new BankApplication();
		ba.accountArray[0] = account1;
		ba.accountArray[1] = account2;
		
		ba.menu();
		
	}

}
