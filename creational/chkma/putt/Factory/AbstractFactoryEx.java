package chkma.putt.Factory;

public class AbstractFactoryEx {
	
	public static void main(String[] args) {
		AbstractFactoryEx a = new AbstractFactoryEx();
		
		PersonFactory p = a.new MaleCompatibleFactory();
		System.out.println(p.getPriority());
		System.out.println(p.getOptional());
	}
	
	
	
	
	public interface PersonFactory { // useful when bundling objects even of different types
		Person getPersonMatch();
		Person getOptional();
		String getPriority();
	}
	
	public class FemaleCompatibleFactory implements PersonFactory {
		@Override
		public Person getPersonMatch() {
			return new Female(null);
		}
		@Override
		public Person getOptional() {
			return new Trans(null);
		}
		@Override
		public String getPriority() {
			return "HIGH";
		}
	}
	
	public class MaleCompatibleFactory implements PersonFactory {
		@Override
		public Person getPersonMatch() {
			return new Male(null);
		}
		@Override
		public Person getOptional() {
			return new Trans(null);
		}
		@Override
		public String getPriority() {
			return "LOW";
		}
	}
	
	
	
}
