package chakman.putt.command;

/**
 * Much better with generics
 * ^Work in Progress^
 * @author AJ
 *
 */
public class CommandPatternWithGenericsEg {


	interface ICommand<Q, T> {
		T execute(Q q);
		void unexecute();
	}
}