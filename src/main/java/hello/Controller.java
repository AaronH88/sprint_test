package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	//can be manually tested by using the following url:
	//http://localhost:8080/transfer?sender=0&receiver=1&amount=0
    @RequestMapping("/transfer")
    public Transfer trans(@RequestParam(value="sender") int senderID, @RequestParam(value="receiver") int receiverID,
    		@RequestParam(value="amount") double amount ) {
    	TransferAgent tA = new TransferAgent();
    	
        return tA.doTransfer(senderID, receiverID, amount);
    }
}