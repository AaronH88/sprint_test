package hello;

import java.util.ArrayList;

public class Account {
	private String type;
	private double balance;
	int id;
	private ArrayList<Transfer> transfers = new ArrayList<Transfer>();
	
	public Account(String type, double balance, int id) {
		this.type = type;
		this.balance = balance;
		this.id = id;
	}
	
	public boolean addFunds(double value) {
		balance += value;
		return true;
	}
	
	public boolean removeFunds(double value) {
		if(value > balance) {
			return false;
		}
		balance -= value;
		return true;
	}
	
	public int getId() {
		return id;
	}
	
	public void addTransfer(Transfer t) {
		transfers.add(t);
	}
	
	public String getType() {
		return type;
	}
}
