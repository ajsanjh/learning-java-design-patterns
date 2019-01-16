package chakman.putt.state;

public class StatePatternEg_TurnStyle {
	public static void main(String[] args) {
		TurnStyle ts = new StatePatternEg_TurnStyle().new TurnStyle();
		
		ts.pay();
		ts.pay();
		ts.enter();
		ts.enter();
		ts.payFail();  // does not affect the state
		ts.enter();
		ts.pay();
		ts.payFail();
		ts.enter();
	}


	class TurnStyle {
		private State state;
		public TurnStyle() {
			this.state = new ClosedState();
		}
		void pay() {
			System.out.println("paying ..");
			this.state.pay(this);
		}
		void payFail() {
			System.out.println("pay failed ..");
			this.state.payFail(this);
		}
		void enter() {
			System.out.println("entring ..");
			this.state.enter(this);
		}
		void setState(State state) {
			this.state = state;
		}
	}
	
	class State {
		void pay(TurnStyle ts) {
			System.out.println("already payed: open");
		}
		void payFail(TurnStyle ts) {	// can still be overridden by implementing classes.
			System.out.println("payment failed");
		}
		void enter(TurnStyle ts) {
			System.out.println("cannot enter");
		}
	}
	
	class OpenState extends State {
		public OpenState() {
			System.out.println("turn style open");
		}
		@Override
		void enter(TurnStyle ts) {
			ts.setState(new ClosedState());
		}
	}
	
	class ClosedState extends State {
		public ClosedState() {
			System.out.println("turn syle closed");
		}
		@Override
		void pay(TurnStyle ts) {
			ts.setState(new OpenState());
		}
		
	}
	
	
	
}