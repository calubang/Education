package test6.bank;

public class Account {
	
	private final int MAX_BALANCE = 100000000;
	private final int MIN_BALANCE = 0;
	private String number;
	private String name;
	private int balance;
	private static int numbering = 0;
	
	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
		numbering++;
		number = "111-" + String.format("%03d", numbering);		
	}
	
	public String getnumber() {
		return number;
	}
	public void setnumber(String number) {
		if((balance >= MIN_BALANCE) && (balance <= MAX_BALANCE)) {
			this.number = number;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int depositAccount(int depositAmount) {
		setBalance(balance + depositAmount);
		return balance;
	}
	public int withdrawAccount(int withdrawAmount) {
		if((balance - withdrawAmount) < 0) {
			System.out.println("출금액이 너무 많습니다.");
			return -1;
		}else {
			setBalance(balance - withdrawAmount);
		}
		return balance;	
	}
	
	@Override
	public String toString() {
		String info = "";
		info = "계좌번호 : " + getnumber();
		info += "\n계좌주 : " + getName();
		info += "\n입금액 : " + getBalance();
		return info;
	}

	

}
