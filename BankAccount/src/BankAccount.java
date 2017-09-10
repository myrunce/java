import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private long checkingBalance;
	private long savingsBalance;
	private static int numberOfMembers = 0;
	private static long moneyStored = 0;
	
	private String tenDigitAccountNum() {
		String accountNum = "";
		for (int i = 0; i < 10; i++) {
			Random r = new Random(10 - 0 + 1);
			accountNum = accountNum.concat(String.valueOf(r)); 
		}
		return accountNum;
	}
	
	public BankAccount() {
		this.accountNumber = tenDigitAccountNum();
		numberOfMembers++;
	}
	
	public long getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public long getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public void deposit(String accName, long amount) {
		if (accName == "checking") {
			this.checkingBalance += amount;
			moneyStored += amount;
		}
		else if (accName == "savings") {
			this.savingsBalance += amount;
			moneyStored += amount;
		}
		else {
			System.out.println("Account not found");
		}
	}
	
	public void withdraw(String accName, long amount) {
		if (accName == "checking") {
			if (amount > this.checkingBalance) {
				System.out.println("Insufficent Funds");
			}
			else {
				this.checkingBalance -= amount;
				moneyStored -= amount;
			}
		}
		else if (accName == "savings") {
			if (amount > this.savingsBalance) {
				System.out.println("Insufficent Funds");
			}
			else {
				this.savingsBalance -= amount;
				moneyStored -= amount;
			}
		}
		else {
			System.out.println("Account not found");
		}
	}
	
	static void totalMoney() {
		System.out.println("Total money stored: " + moneyStored);
	}
}