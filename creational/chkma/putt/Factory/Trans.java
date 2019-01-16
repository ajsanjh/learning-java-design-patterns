package chkma.putt.Factory;

public class Trans implements Person {

	private String name;
	
	public Trans(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return "Trans [name=" + name + "]";
	}
}
