package chakma.putt.decorator;

public class DecoratorPatternBeverageEg {

	public static void main(String[] args) {
		DecoratorPatternBeverageEg d = 
				new DecoratorPatternBeverageEg();
		
		Beverage espresso = d.new Espresso();
		Beverage espressoWithMilk = d.new Milk(espresso);
		Beverage espressoWithMilkAndCaramel = d.new Caramel(espressoWithMilk);
		
		
		System.out.println(espressoWithMilkAndCaramel.getIngredients());
		System.out.println(espressoWithMilkAndCaramel.getPrice());
	}
	
	
	
	/**
	 * contract between concrete/base class and decorator
	 */
	private interface Beverage {
		String getIngredients();
		int getPrice();
	}
	
	
	/**
	 * first concrete/base class
	 */
	private class Espresso implements Beverage {
		@Override
		public String getIngredients() {
			return "Single Espresso Shot";
		}
		@Override
		public int getPrice() {
			return 2;
		}
	}
	
	/**
	 * second concrete/base class
	 */
	private class Drip implements Beverage {
		@Override
		public String getIngredients() {
			return "8oz cup";
		}
		@Override
		public int getPrice() {
			return 1;
		}
	}
	
	
	/**
	 * the decorator contract or some impl i.e. an abstract class
	 */
	private class BeverageDecorator implements Beverage {
		protected Beverage beverage;
		public BeverageDecorator(Beverage beverage) {
			this.beverage = beverage;
		}
		@Override
		public String getIngredients() {
			return this.beverage.getIngredients() + "  >Adding: ";
		}
		@Override
		public int getPrice() {
			return this.beverage.getPrice();
		}
	}
	
	
	private class Milk extends BeverageDecorator {
		public Milk(Beverage beverage) {
			super(beverage);
		}
		@Override
		public String getIngredients() {
			return this.beverage.getIngredients() + " + Milk";
		}
		@Override
		public int getPrice() {
			return this.beverage.getPrice() + 1;
		}
	}
	
	private class Caramel extends BeverageDecorator {
		public Caramel(Beverage beverage) {
			super(beverage);
		}
		@Override
		public String getIngredients() {
			return this.beverage.getIngredients() + " + Caramel";
		}
		@Override
		public int getPrice() {
			return this.beverage.getPrice() + 1;
		}
	}
	
	
	
	
	
}
