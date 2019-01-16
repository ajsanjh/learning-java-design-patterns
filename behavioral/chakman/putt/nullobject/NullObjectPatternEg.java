package chakman.putt.nullobject;

import java.lang.reflect.Proxy;

/**
 * Issue is the sometime we don't want to pass a dependency when
 * instantiating an object that require dependency i.e. it uses
 * methods from the dependency. we can use null object design pattern
 * to solve this issue.
 * @author AJ
 *
 */
public class NullObjectPatternEg {

}

class Issue {
	// dependency
	interface Log { void info(String msg); }
	// dependency impl
	class ConsoleLog implements Log { public void info(String msg) { System.out.println(msg); }}

	// our object
	class BankAccount {
		private Log log;
		BankAccount(Log log) {this.log = log;}  // obj has dependency
		void deposit(double amount) {
			// operation of deposit
			log.info("Deposited: " + amount);   // use of depen. so can't be null
		}
	}
}

/*
 * as a solution we can check for null but it will add a lot of overhead
 * ::: instead we construct a null object of Log
 * ::: NOTE: the null object can be statefull i.e.dependent can't depend on it's result.
 */
class Solution {
	// dependency
	interface Log { void info(String msg); }
	// dependency impl
	class ConsoleLog implements Log { public void info(String msg) { System.out.println(msg); }}

	// Null Object of Log
	class NullLog implements Log { public void info(String msg) {}} // no business logic.
	
	// our object
	class BankAccount {
		private Log log;
		BankAccount(Log log) {this.log = log;}  // obj has dependency
		void deposit(double amount) {
			// operation of deposit
			log.info("Deposited: " + amount);   // use of depen. so can't be null
		}
	}
}


/*
 * dynamic null object
 * eg. Log got = Solution2.NullProxy.noOp(Log.class);
 * 
 * note: they are very computationally intensive
 */
class Solution2 {
	// make a dynamic proxy 
	static class NullProxy {
		@SuppressWarnings("unchecked")
		public static <T> T noOp(Class<T> itf) {
			return (T) Proxy.newProxyInstance(
					itf.getClassLoader(),
					new Class<?>[] {itf},
					(proxy, method, args) ->
						{
							if(method.getReturnType().equals(Void.TYPE))
								return null;
							else
								return method.getReturnType().getConstructor().newInstance();
						}
 					);
		}
	}
}


















