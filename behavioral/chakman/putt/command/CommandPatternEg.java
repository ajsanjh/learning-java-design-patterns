package chakman.putt.command;

public class CommandPatternEg {

	public static void main(String[] args) {
		CommandPatternEg c = new CommandPatternEg();
		c.new CommandHandler(c.new Command("hello"), null).executeCommand1();
	}

	/**
	 * think if command pattern as encapsulating a function, i.e. execute() in
	 * this case and to be able to pass it around as part of an object: since
	 * before version 8, Java didn't support functional programming. 
	 */
	interface ICommand {
		void execute();
		void unexecute();
	}
	/**
	 * very specific impl for our needs.
	 * @author AJ
	 *
	 */
	class Command implements ICommand {
		String action = null;
		public Command(String action) {
			this.action = action;
		}
		@Override
		public void execute() {
			System.out.println("execute the command: " + this.action);
		}
		@Override
		public void unexecute() {
		}
	}

	/** to handle and manage commands eg. in a queue.
	 * this normally will take all command instance in your case:
	 * e.g. onCommand, offCommand, etc. and has more complex logic for
	 * handling and queuing. */
	class CommandHandler {
		ICommand command1, command2;
		CommandHandler(ICommand command1, ICommand command2) {
			this.command1 = command1;
			this.command2 = command2;
		}
		void executeCommand1() {
			this.command1.execute();
		}
		void executeCommand2() {
			this.command2.execute();
		}
	}
	


}


