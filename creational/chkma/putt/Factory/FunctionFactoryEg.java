package chkma.putt.Factory;

public class FunctionFactoryEg {

	public static void main(String[] args) {
		FunctionFactoryEg f = new FunctionFactoryEg();
		PersonFactory factory = f.new MalePersonFactory();
		Person person = factory.createPerson("ajay");
		System.out.println(person.toString());
		
	}
	
	
	public abstract class PersonFactory {  // could be an interface but remember child class can implement multiple interfaces.
		public abstract Person createPerson(String name);
	}
	
	
	public class MalePersonFactory extends PersonFactory{
		@Override
		public Person createPerson(String name) {
			return new Male(name);
		}
	}
	
	public class FemalePersonFactory extends PersonFactory {
		@Override
		public Person createPerson(String name) {
			return new Female(name);
		}
	}
	
}
