import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LoggingTransaction {
	public static void main(String args) {
		List<Integer> transactionIds = Arrays.asList(101, 111, 123, 323, 131);
		transactionIds.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
	}
}
