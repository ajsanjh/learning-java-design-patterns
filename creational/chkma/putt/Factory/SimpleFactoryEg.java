package chkma.putt.Factory;

public class SimpleFactoryEg {
	
	public static void main(String[] args) {
		
	}

	
	
	public static class PersonFactory {
		public static Person getPerson(String gender, String name) {
			if(gender.toLowerCase().startsWith("m")) {
				return new Male(name);
			} else if(gender.toLowerCase().startsWith("f")) {
				return new Female(name);
			} else {
				return null;
			}
		}
	}
}



