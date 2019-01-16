package chakma.putt.proxy;
/**
 * proxy pattern raise on detra:
 * issue we don't want to expose entire employee data to different
 * internal departments
 * e.g. HR does not need to know employee's bank account
 * 
 * sol.: provide Proxy data to HR i.e. expose only what needs to be exposed.
 * 
 * impl: employee data adheres to a contract with interface like GetEmployeeHrData
 * and a proxy with same contract will return the real data. We will only expose 
 * proxy class.
 * 
 * @author AJ
 *
 */
public class ProxyEx {
	
	public static void main(String[] args) {
		ProxyEx p = new ProxyEx();
		
		GetEmployeeHrData ehrData = p.new EmployeeHrDataProxy(); // exposed only HR data
		
		System.out.println(ehrData.getName());
		System.out.println(ehrData.getAddress());
		
//		ehrData.getSalary();   CE! ->  
	}
	
	
	
	
	private interface GetEmployeeHrData {
		public String getName();
		public Address getAddress();
	}
	
	private class EmployeeHrDataProxy implements GetEmployeeHrData {

		// @Injected or @AutoWired  i.e. DI since employeeData already exists somewhere in context
		private EmployeeData employeeData;
		public EmployeeHrDataProxy() {
		}
		
		@Override
		public String getName() {
			return this.employeeData.getName(); // return the real thing
		}
		@Override
		public Address getAddress() {
			return this.employeeData.getAddress(); // returns the real thing
		}
	}
	
	
	private class EmployeeData implements GetEmployeeHrData{
		
		private String name;
		private Address address;
		private Integer salary;
		private String skillLevel;
		private BankAccount bankAccount;
		public String getName() {
			return name;
		}
		public Address getAddress() {
			return address;
		}
		public Integer getSalary() {
			return salary;
		}
		public String getSkillLevel() {
			return skillLevel;
		}
		public BankAccount getBankAccount() {
			return bankAccount;
		}
	}
	
	private class Address {
		private String houseNo;
		private String street;
		private String city;
		private String state;
		private String zip;
		private String country;
	}
	
	private class BankAccount {
		private String bankName;
		private Address bankAddress;
		private Integer accountNo;
	}
	
	
}
