package chakma.putt.adapter;

public class AtapterPatternEg {

	
	
	
	
	
	private class Client {
		public void execute() {
			Target target = new Adapter(new Adaptee());
			target.request();
			
		}
	}
	
	private interface Target {
		void request();
	}
	
	private class Adapter implements Target {
		private Adaptee adaptee;
		public Adapter(Adaptee adaptee) {
			this.adaptee = adaptee;
		}
		@Override
		public void request() {
			this.adaptee.specificRequest();
		}
		
	}

	
	private class Adaptee {
		public void specificRequest() {
			System.out.println("Specific request !");
		}
	}
	
	
}
