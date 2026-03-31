import java.util.ArrayList;
import java.util.List;

class Invoice{
	String transactionId;
	
	public Invoice(String transactionId) {
		this.transactionId = transactionId;
	}
	
	@Override
	public String toString() {
		return "Invoice [ Transaction Id : " + transactionId + " ]";
	}
}
public class InvoiceCreation {
	public static void main(String[] args) {
		List<String> transactionList = new ArrayList<>();
		transactionList.add("TXO1234");
		transactionList.add("AIC9877");
		transactionList.add("TBC0198");
		transactionList.add("KFC8738");
		
		List<Invoice> invoiceList = transactionList.stream().map(Invoice::new).toList();
		invoiceList.forEach(System.out::println);
		
	}
}
