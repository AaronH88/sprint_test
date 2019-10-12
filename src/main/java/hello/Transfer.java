package hello;

public abstract class Transfer {
	private int transferId;
	private Account sender;
	private Account receiver;
	
	public int getID() {
		return transferId;
	}
	public void setID(int transferId) {
		this.transferId = transferId;
	}
	
	public void setSender(Account sender) {
		this.sender = sender;
	}
	
	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}
	
	public Account getSender() {
		return sender;
	}
	
	public Account getReceiver() {
		return receiver;
	}
	
	public boolean sendTransfer(double value) {
		if(!sender.removeFunds(value)) {
			return false;
		}
		if(!receiver.addFunds(value)) {
			return false;
		}
		return true;
	}

}
