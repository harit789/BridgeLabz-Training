import java.util.Arrays;
import java.util.List;

public class EmailNotification {
	
	public static void sendEmailNotification(String email) {
		System.out.println("Notification from Email : " + email);
	}
	public static void main(String args[]) {
		List<String> emails = Arrays.asList("user@gmail.com" , "exveno@gmail.com" , "viper@co.in");
		emails.stream().forEach(email -> sendEmailNotification(email));
	}
}
