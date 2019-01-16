package chakman.putt.command;

public class FunctionalProgramingInsteadOfCommandPatternEg {

	public static void main(String[] args) {
		FunctionalProgramingInsteadOfCommandPatternEg f =
				new FunctionalProgramingInsteadOfCommandPatternEg();
		
		f.new Driver().run();
	}
	
	
	
	
	@FunctionalInterface
	interface ICommand {
		void execute();
	}
	
	class Driver {
		/* ** this function can be passed around.
		 * new functions can be created on the fly. */
		ICommand cmd = () -> System.out.println("logic");
		
		void run() {
			new Handler().run(cmd);
		}
	}
	
	
	class Handler {
		void run(ICommand command) {
			command.execute();
		}
	}
	
	
	
}
