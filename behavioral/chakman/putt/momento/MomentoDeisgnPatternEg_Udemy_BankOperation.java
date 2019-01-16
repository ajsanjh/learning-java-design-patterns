package chakman.putt.momento;

public class MomentoDeisgnPatternEg_Udemy_BankOperation {
	public static void main(String[] args) {
		BankAccount ba  = new BankAccount(100);
		Memento m1 = ba.deposit(50);
		Memento m2 = ba.deposit(25);
		
		System.out.println(ba);
		ba.restore(m1);
		System.out.println(ba);
		ba.restore(m2);
		System.out.println(ba);
	}
	
}


class Memento {   // generally an immutable class so it can't be changed once composed
	public int blance;
	public Memento(int blance) {
		this.blance = blance;
	}
}

class BankAccount {
	private int balance;
	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}
	public Memento deposit(int ammount) {
		this.balance += ammount;
		return new Memento(balance);
	}
	public void restore(Memento m) {
		this.balance = m.blance;
	}
	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}
}