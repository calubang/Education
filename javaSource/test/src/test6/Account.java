package test6;

public class Account {
	
	private int balance;
	private String name;
	private String accountNumber;
	private static int accountNumbering;
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	public Account(String name, int balance) {
		this.accountNumbering++;
		accountNumber = "111-" + String.format("%03", accountNumbering);
		this.name = name;
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}else {
			System.out.println("°ªÀÌ ¹üÀ§¸¦ ¹þ¾î³µ½À´Ï´Ù.");
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	@Override
	public String toString() {
		String info = "";
		info += "°èÁÂ¹øÈ£ : " + getAccountNumber();
		info += "°èÁÂÁÖ : " + getName();
		return info; 
	}
	
}
