package chkma.putt.Singleton;

public class Singleton {

	public static void main(String[] args) {
		EmployeeBase e1 = EmployeeBase.getEmployeeBase();
		EmployeeBase e2 = EmployeeBase.getEmployeeBase();
		
		e1.setNoOfEmployee(101);
		
		
		System.out.println(e2.getNoOfEmployee());
	}
	
	
}


class CompanyOne {
	
}

class EmployeeBase {
	private int noOfEmployee;
	private int averagePay;
	
	
	private static EmployeeBase employeeBase;
	
	public static EmployeeBase getEmployeeBase() {
		if(employeeBase == null) {
			employeeBase =  new EmployeeBase(100, 10000);
		}
		return employeeBase;
	}
	
	
	private EmployeeBase(int noOfEmployee, int averagePay) {
		super();
		this.noOfEmployee = noOfEmployee;
		this.averagePay = averagePay;
	}

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public int getAveragePay() {
		return averagePay;
	}

	public void setAveragePay(int averagePay) {
		this.averagePay = averagePay;
	}
}