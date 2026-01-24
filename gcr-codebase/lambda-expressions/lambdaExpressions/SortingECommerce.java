package lambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ECommerce {
	double price;
	double rating;
	double discount;

	public ECommerce(double price, double rating, double discount) {
		this.price = price;
		this.rating = rating;
		this.discount = discount;
	}

	public String toString() {
		return "ECommerce [Price=" + price + ", Rating=" + rating + ", Discount=" + discount + "]";
	}
}

public class SortingECommerce {
	public static void main(String[] args) {

		List<ECommerce> list = new ArrayList<>();
		list.add(new ECommerce(100, 3.0, 10));
		list.add(new ECommerce(200, 4.0, 15));
		list.add(new ECommerce(50, 1.5, 1));
		list.add(new ECommerce(199, 4.7, 18));

		Collections.sort(list, (e1, e2) -> Double.compare(e1.price, e2.price));
		System.out.println("Sorted by Price:");
		list.forEach(System.out::println);

		Collections.sort(list, (e1, e2) -> Double.compare(e2.rating, e1.rating));
		System.out.println("Sorted by Rating:");
		list.forEach(System.out::println);

		Collections.sort(list, (e1, e2) -> Double.compare(e2.discount, e1.discount));
		System.out.println("Sorted by Discount:");
		list.forEach(System.out::println);
	}
}
