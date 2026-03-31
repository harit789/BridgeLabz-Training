import java.util.ArrayList;
import java.util.List;

public class NameUppercasing {
	public static void main(String[] args) {
		List<String> employeesName = new ArrayList<>();
		employeesName.add("harit");
		employeesName.add("harsh");
		employeesName.add("aditya");
		employeesName.add("kunal");
		employeesName.add("aryan");
		
		employeesName.stream().map(String::toUpperCase).forEach(System.out::println);
	}
}
