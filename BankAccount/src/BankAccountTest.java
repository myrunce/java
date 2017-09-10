
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount myAcc = new BankAccount();
		
		myAcc.deposit("checking", 500);
		myAcc.deposit("savings", 500);
		myAcc.deposit("chesdscking", 500);
		myAcc.withdraw("checking", 750);
		myAcc.withdraw("savings", 200);
		System.out.println(myAcc.getCheckingBalance());
		System.out.println(myAcc.getSavingsBalance());
		BankAccount.totalMoney();
	}

}
