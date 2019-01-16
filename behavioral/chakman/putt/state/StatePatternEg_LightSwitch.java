package chakman.putt.state;


public class StatePatternEg_LightSwitch { 
	public static void main(String[] args) {
		LightSwitch ls = new StatePatternEg_LightSwitch().new LightSwitch();
		ls.on();
		ls.off();
		ls.off();
		ls.on();
		ls.on();
	}


	class LightSwitch {
		private State state;
		public LightSwitch() {
			this.state = new OffState();
		}
		void on() {
			System.out.println("turning lights on ....");
			this.state.on(this);
		}
		void off() {
			System.out.println("turning lights off ....");
			this.state.off(this);
		}
		void setState(State state) {
			this.state = state;
		}
	}

	abstract class State {
		void on(LightSwitch ls) {
			System.out.println("lights are already on: state on");
		}
		void off(LightSwitch ls) {
			System.out.println("lights are already off: state off");
		}
	}

	class OnState extends State{
		public OnState() {
			System.out.println("lights are on now: state on");
		}
		@Override
		void off(LightSwitch ls) {
			ls.setState(new OffState());
		}
	}

	class OffState extends State {
		public OffState() {
			System.out.println("lights are off now: state off");
		}
		@Override
		void on(LightSwitch ls) {
			ls.setState(new OnState());
		}
	}

} 

