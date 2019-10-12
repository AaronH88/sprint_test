package hello;

public class Customer {
	private String name;
	private Account acc;
	
	public Customer(String name, Account acc) {
		this.name = name;
		this.acc = acc;
	}
	
	public Account getAccount() {
		return acc;
	}
	
	public String getName() {
		return name;
	}

}
