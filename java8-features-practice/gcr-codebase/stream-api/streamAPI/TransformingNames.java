
import java.util.ArrayList;
import java.util.List;

class Customer{
	String name;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public String toString() {
		return " Customer [ Name " + name + "]";
	}
}
public class TransformingNames {
	public static void main(String args[]) {
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("raj"));
		list.add(new Customer("suresh"));
		list.add(new Customer("manoj"));
		list.add(new Customer("kapil"));
		list.add(new Customer("aryan"));
		
		list.stream().map(c -> c.name.toUpperCase()).sorted().forEach(System.out::println);
	}
}
