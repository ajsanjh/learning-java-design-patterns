package chakma.putt.decorator;

public class DecoratorEx {

	
	public static void main(String[] args) {
		DecoratorEx d = new DecoratorEx();
		
		Pizza basicPizza = d.new TomatoSauce(d.new Mozzarella(d.new PlainPizza()));
		
		
		System.out.println("ingredients: " + basicPizza.getDescription());
		System.out.println("cost: " + basicPizza.getCost());
	}
	
	
	
	
	
	private interface Pizza {
		String getDescription();
		double getCost();
	}

	
	private class PlainPizza implements Pizza{
		@Override
		public String getDescription() {
			return "Thin Crust";
		}
		@Override
		public double getCost() {
			return 4;
		}
	}
	
	
	private class ToppingDeocrator implements Pizza {
		protected Pizza tempPizza;
		
		public ToppingDeocrator(Pizza newPizza) {
			this.tempPizza = newPizza;
		}
		@Override
		public String getDescription() {
			return tempPizza.getDescription();
		}
		@Override
		public double getCost() {
			return tempPizza.getCost();
		}
	}
	
	
	private class Mozzarella extends ToppingDeocrator {

		public Mozzarella(Pizza newPizza) {
			super(newPizza);
			System.out.println("Adding Moz");
		}
		@Override
		public String getDescription() {
			return tempPizza.getDescription() + " , Mozzarella";
		}
		@Override
		public double getCost() {
			return tempPizza.getCost() + 0.50;
		}
	}
	
	
	private class TomatoSauce extends ToppingDeocrator {

		public TomatoSauce(Pizza newPizza) {
			super(newPizza);
			
			System.out.println("Adding Sauce");
		}
		@Override
		public String getDescription() {
			return tempPizza.getDescription() + " , Sauce";
		}
		@Override
		public double getCost() {
			return tempPizza.getCost() + 0.50;
		}
	}
	
	
}
