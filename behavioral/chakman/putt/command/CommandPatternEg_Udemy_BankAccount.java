package chakman.putt.command;

import java.util.Arrays;
import java.util.List;

public class CommandPatternEg_Udemy_BankAccount {
	public static void main(String[] args) {
		new Demo().runme();
	}
}


class Demo {
	public void runme() {
		BankAccount ba = new BankAccount();
		System.out.println(ba);
		
		List<BankAccountCommand> commands = Arrays.asList(
				new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),  // note how our command is all set with data it requires as an object. All we need is to pass to the receiver and they can just call the call() method to execute the command. 
				new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 100));
		
		for (BankAccountCommand c : commands) {
			c.call();
			System.out.println(ba);
		}
		
	}
}


class BankAccount {
	private int balance;
	private int overdraftLimit = -500;

	public void deposit(int amount) {
		this.balance += amount;
		System.out.println("Deposited " + amount + 
				", balance is now " + balance);
	}

	public void withdraw(int amount) {
		balance -= amount;
		System.out.println("Withdrew " + amount
				+ ", balance is now " + balance);
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", overdraftLimit=" + overdraftLimit + "]";
	}
}


interface Command {
	void call(); // the execute method
}

class BankAccountCommand implements Command{
	private BankAccount account;

	public enum Action {
		DEPOSIT, WITHDRAW
	}
	
	private Action action;
	private int amount;
	public BankAccountCommand(BankAccount account, Action action, int amount) {
		this.account = account;
		this.action = action;
		this.amount = amount;
	}
	@Override
	public void call() {
		switch (action) {
		case DEPOSIT:
			account.deposit(amount);
			break;
		case WITHDRAW:
			account.withdraw(amount);
			break;
		}
	}
}




