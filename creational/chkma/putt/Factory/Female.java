package chkma.putt.Factory;

public class Female implements Person {
	private String name;
	public Female(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return "Female [name=" + name + "]";
	}
}