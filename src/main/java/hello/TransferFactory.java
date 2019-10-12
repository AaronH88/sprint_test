package hello;

public class TransferFactory {
	
	public Transfer makeTransfer(Account sender, Account receiver, String newTransferType){
		//String newTransferType;
		//if(sender.getBank().getName().equals(receiver.getBank().getName())) {
			//newTransferType = "Intra";
		//} else
			//newTransferType = "Inter";
			
		if (newTransferType.equals("Intra")){
			return new IntraBankTransfer(sender, receiver);			
		} else 		
		if (newTransferType.equals("Inter")){			
			return new InterBankTransfer(sender, receiver);			
		} else
			return null;
	}

}
