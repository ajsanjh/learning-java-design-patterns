package chakman.putt.command;

public class SapCommandHandling {

	
	
	
	
	private interface ServiceCommand<R> {
		
	}
	
	private interface ServiceCommandImpl<R, C extends ServiceCommand<R>> {
		R execute(C cmd);
	}
	
	class Command implements ServiceCommand<String> {
		String hello = "hello";
	}
	
	
	class CommandImpl implements ServiceCommandImpl<String, Command> {
		@Override
		public String execute(Command cmd) {
			return cmd.hello;
		}
	}

	
	
	
	
	private interface ServiceCommandHandler {
		<R, C extends ServiceCommand<R>> R executes(C cmd);
	}
	
}
