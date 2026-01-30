import java.util.Arrays;
import java.util.List;

public class AttendeeWelcomeMsg {
	public static void main(String[] args) {
		List<String> students = Arrays.asList("Harit", "Aditya" , "Kunal" , "Shiv");
		students.stream().forEach(student -> System.out.println("Welcome! to event, "+ student));
	}
}
