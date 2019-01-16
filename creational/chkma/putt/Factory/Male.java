package chkma.putt.Factory;

public class Male implements Person {
	private String name;
	public Male(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return "Male [name=" + name + "]";
	}
}
