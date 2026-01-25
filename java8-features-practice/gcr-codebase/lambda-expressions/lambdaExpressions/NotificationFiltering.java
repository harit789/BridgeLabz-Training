package lambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Alert{
	String type;
	String message;
	
	public Alert(String type, String message) {
		this.type = type;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Alert [ Type = " + type + " , Message = " + message + " ]";
	}
}
public class NotificationFiltering {
	public static void main(String[] args) {
		List<Alert> alerts = new ArrayList<>();
		alerts.add(new Alert("Emergency", "High BP"));
		alerts.add(new Alert("Billing", "Pending Bills"));
		alerts.add(new Alert("Appointment", "Docotir Visit"));
		alerts.add(new Alert("Emergency", "Accident"));
		
		Predicate<Alert> emergencyOnly = (alert) -> alert.type.equalsIgnoreCase("emergency");
		
		for(Alert alert : alerts) {
			if(emergencyOnly.test(alert)) {
				System.out.println(alert);
			}
		}
	}
}
