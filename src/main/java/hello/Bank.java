package hello;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public Bank(String name) {
		this.name = name;
	}
	
	public void addCustomer(Customer c) {
		customers.add(c);
	}
	
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
	public String getName() {
		return name;
	}
	
	//@TODO, Remove, Search customers
}
