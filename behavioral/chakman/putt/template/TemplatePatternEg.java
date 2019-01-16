package chakman.putt.template;

public class TemplatePatternEg {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		boolean runtime = false;  // could be set at runtime
		A a = null;
		
		if(runtime) {
			a = new B(); // operation impl is changed at runtime
		} else {
			Class c = Class.forName("chakman.putt.template.C"); // sort of DI
			a = (C) c.newInstance();  // operation impl is changed at runtime
		}
		
		a.templateMethod();
		
	}
	
}


abstract class A {
	final void templateMethod() {
		operation();
	}
	abstract void operation();
	// ...
	// ...
	// ... more operations that will be overridden by implementing classes.
}




class B extends A {
	@Override
	void operation() {
		// could be a complex algorithm
		System.out.println("class b operations");
	}
}
class C extends A {
	@Override
	void operation() {
		// could be a complex algorithm
		System.out.println("class c operations");
	}
}


