package hello;

public class TransferAgent {
	TransferFactory transF = new TransferFactory();
	
	Transfer trans = null;
	Bank b1 = new Bank("ABC");
	Bank b2 = new Bank("DEF");
	
	public TransferAgent() {
		init();
	}
	
	public void init() {
		Account a1 = new Account("Checking", 100, 0);
		Account a2 = new Account("Savings", 1000, 1);
		Account a3 = new Account("Checking", 500, 3);
		Customer c1 = new Customer("Dave", a1);
		Customer c2 = new Customer("Bill", a2);
		Customer c3 = new Customer("Julie", a3);
		b1.addCustomer(c1);
		b1.addCustomer(c2);
		b2.addCustomer(c3);
	}
	
	
	public Transfer doTransfer(int senderID, int receiverID, double value) {
		Account sender = findAccountByID(senderID);
		Account receiver = findAccountByID(receiverID);
		String newTransferType = findTransType(senderID, receiverID);
		
		trans = transF.makeTransfer(sender, receiver , newTransferType);
		if(trans.sendTransfer(value)) {
			sender.addTransfer(trans);
			receiver.addTransfer(trans);
			return trans;
		}else
			return null;
	}
	
	public Account findAccountByID(int id) {
		Account found = null;
		
		for(int i = 0; i < b1.getCustomers().size(); i++) {
			if(b1.getCustomers().get(i).getAccount().getId() == id) {
				found = b1.getCustomers().get(i).getAccount();
			}
		}
		
		if(found == null) {
			for(int i = 0; i < b2.getCustomers().size(); i++) {
				if(b2.getCustomers().get(i).getAccount().getId() == id) {
					found = b2.getCustomers().get(i).getAccount();
				}
			}
		}
		
		return found;
	}

	public String findTransType(int senderID, int receiverID) {
		String senderBank = "";
		String receiverBank = "";
		
		for(int i = 0; i < b1.getCustomers().size(); i++) {
			if(b1.getCustomers().get(i).getAccount().getId() == senderID) {
				senderBank= b1.getName();
			}
			if(b1.getCustomers().get(i).getAccount().getId() == receiverID) {
				receiverBank = b1.getName();
			}
		}
		if(senderBank.equals(receiverBank)) {
			return "Intra";
		}
		
		return "Inter";
	}
}
