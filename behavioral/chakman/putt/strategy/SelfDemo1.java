package chakman.putt.strategy;

import java.util.Arrays;
import java.util.List;

public class SelfDemo1 {
	public static void main(String[] args) {
		Piza piza = new SelfDemo1().new DeepDishStyle();

		SelfDemo1 s = new SelfDemo1();
		
		Piza p2 = new SelfDemo1().new PizaImpl(
				s.new ThickCrust(), 
				s.new MarinaraFilling(), 
				s.new MozzarellaCheese(), 
				Arrays.asList(s.new BellPeppers(), s.new ItalianSausage())
				);
		p2.crust();
		p2.topping();
	}
	
	
	private interface Piza {
		void crust();
		void filing();
		void cheese();
		void topping();
	}
	
	private class PizaImpl implements Piza {
		CrustBehavoir crust;
		FillingBehavoir filling;
		CheeseBehavoir cheese;
		List<ToppingBehavior> topping;
		public PizaImpl(
				CrustBehavoir crust, 
				FillingBehavoir filling, 
				CheeseBehavoir cheese,
				List<ToppingBehavior> topping) {
			super();
			this.crust = crust;
			this.filling = filling;
			this.cheese = cheese;
			this.topping = topping;
		}
		@Override
		public void crust() {
			this.crust.execute();
		}
		@Override
		public void filing() {
			this.filling.execute();
		}
		@Override
		public void cheese() {
			this.cheese.execute();
		}
		@Override
		public void topping() {
			topping.stream().forEach(
					i -> i.execute());
		}
		
		
	}
	
	
	private interface CrustBehavoir {
		void execute();
	}
	
	private interface FillingBehavoir {
		void execute();
	}
	
	private interface CheeseBehavoir {
		void execute();
	}
	
	public interface ToppingBehavior {
		void execute();
	}
	
	
	private class ThickCrust implements CrustBehavoir {
		@Override
		public void execute() {
			System.out.println("thick crust");
		}
	}
	
	private class PanCrust implements CrustBehavoir {
		@Override
		public void execute() {
			System.out.println("pan crust");
		}
	}
	
	private class MarinaraFilling implements FillingBehavoir {
		@Override
		public void execute() {
			System.out.println("marinara sause filling");
		}
	}
	
	private class MozzarellaCheese implements CheeseBehavoir {
		@Override
		public void execute() {
			System.out.println("mozzarella cheese");
		}
	}
	
	private class ItalianSausage implements ToppingBehavior {
		@Override
		public void execute() {
			System.out.println("Toping: italian sausage");
		}
	}
	private class BellPeppers implements ToppingBehavior {
		@Override
		public void execute() {
			System.out.println("Toping: Bell Peppers");
		}
	}
	private class PineApple implements ToppingBehavior {
		@Override
		public void execute() {
			System.out.println("Toping: pineapple");
		}
	}
	private class Onion implements ToppingBehavior {
		@Override
		public void execute() {
			System.out.println("Toping: onion");
		}
	}
	
	
	
	private class DeepDishStyle implements Piza {
		@Override
		public void crust() {
			System.out.println("Thick crust");
		}
		@Override
		public void filing() {
			System.out.println("marinara sause");
		}
		@Override
		public void cheese() {
			System.out.println("mozzarella cheese");
		}
		@Override
		public void topping() {
			System.out.println("italian sausage, bell pepper, pineapple, onions");
		}
	}
	
	
	
}
