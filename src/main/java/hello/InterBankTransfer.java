package hello;

public class InterBankTransfer extends Transfer {
	
	public InterBankTransfer(Account sender, Account receiver) {
		setSender(sender);
		setReceiver(receiver);
	}

	@Override
	public boolean sendTransfer(double value) {
		if(value > 1000) {
			return false;
		}
		
		if(Math.random()*10 < 3) {
			return false;
		}
		
		if(!getSender().removeFunds((value + 5))) {
			return false;
		}
		
		if(!getReceiver().addFunds(value)) {
			return false;
		}
		
		return true;
	}
}
