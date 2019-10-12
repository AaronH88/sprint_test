package hello;

public class IntraBankTransfer extends Transfer {
	
	public IntraBankTransfer(Account sender, Account receiver) {
		setSender(sender);
		setReceiver(receiver);
	}
}
