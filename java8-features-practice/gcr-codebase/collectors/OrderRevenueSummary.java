import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
	private String customer;
	private double total;

	public Order(String customer, double total) {
		this.customer = customer;
		this.total = total;
	}

	public String getCustomer() {
		return customer;
	}

	public double getTotal() {
		return total;
	}
}

public class OrderRevenueSummary {
	public static void main(String[] args) {
		
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("harsh", 249.0));
		orders.add(new Order("aryan", 434.2));
		orders.add(new Order("harsh", 131.1));
		orders.add(new Order("aryan", 786.0));
		
		Map<String, Double> revenueByCustomer = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getTotal)));
		revenueByCustomer.forEach((customer, total) -> System.out.println(customer + " -> " + total));
	}
}
