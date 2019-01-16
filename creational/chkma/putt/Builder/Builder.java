package chkma.putt.Builder;


public class Builder {

	public static void main(String[] args) {
		Dinner d = new Dinner.DinnerBuilder()
				.drink("shampane")
				.desert("cheese cake")
				.build();
		
		System.out.println(d);
	}
}

class Dinner {
	private String drink;
	private String Starters;
	private String mainCourse;
	private String desert;
	public Dinner() {
		
	}
	private Dinner(String drink, String starters, String mainCourse, String desert) {
		super();
		this.drink = drink;
		Starters = starters;
		this.mainCourse = mainCourse;
		this.desert = desert;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getStarters() {
		return Starters;
	}
	public void setStarters(String starters) {
		Starters = starters;
	}
	public String getMainCourse() {
		return mainCourse;
	}
	public void setMainCourse(String mainCourse) {
		this.mainCourse = mainCourse;
	}
	public String getDesert() {
		return desert;
	}
	public void setDesert(String desert) {
		this.desert = desert;
	}
	@Override
	public String toString() {
		return "Dinner [drink=" + drink + ", Starters=" + Starters + ", mainCourse=" + mainCourse + ", desert=" + desert
				+ "]";
	}
	public static class DinnerBuilder {
		private String drink;
		private String starters;
		private String mainCourse;
		private String desert;
		public DinnerBuilder drink(String drink) {
			this.drink = drink;
			return this;
		}
		public DinnerBuilder starters(String starters) {
			this.starters = starters;
			return this;
		}
		public DinnerBuilder mainCourse(String mainCourse) {
			this.mainCourse = mainCourse;
			return this;
		}
		public DinnerBuilder desert(String desert) {
			this.desert = desert;
			return this;
		}
		public Dinner build() {
			return new Dinner(drink, starters, mainCourse, desert);
		}
	}
}
