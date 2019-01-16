package chakman.putt.strategy;

public class StrategyPatternEx {

	public static void main(String[] args) {
		Duck wildDuck = 
				new DuckContext(new BigDuckDisplayImpl(), new LoudQuackImpl());
		
		wildDuck.display();
		wildDuck.quack();
	}
	
	
	
}

/*
 * instead of inheritance like below(inside comments), which make the code not 
 * flexible at all,use Strategy pattern to create behaviors like display and 
 * quack below for a duck and provide a blueprint of the duck where we can 
 * inject the behavior and create our custom duck 
 * e.g. as showin in main above
 * 
interface Duck {
	void display();
}
class WildDuck implements Duck {
	@Override
	public void display() {
		System.out.println("wild duck");
	}
}
 */



/** this interface is optional can work with just DuckContext class
 * as well. But the interface does give a nice contract. 
 */
interface Duck extends DisplayBehavior, QuackBehavior {
}

class DuckContext implements Duck {
	private DisplayBehavior db;
	private QuackBehavior qb;
	public DuckContext(DisplayBehavior db, QuackBehavior qb) {
		super();
		this.db = db;
		this.qb = qb;
	}
	@Override
	public void display() {
		this.db.display();
	}
	@Override
	public void quack() {
		this.qb.quack();
	}
}




interface DisplayBehavior {
	void display();
}
class BigDuckDisplayImpl implements DisplayBehavior {
	@Override
	public void display() {
		System.out.println("wild duck");
	}
}
class SmallDuckDisplayImpl implements DisplayBehavior {
	@Override
	public void display() {
		System.out.println("city duck");
	}
}


interface QuackBehavior {
	void quack();
}

class LoudQuackImpl implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("loud quack");
	}
}
class NoQuackImpl implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("no quack");
	}
}




