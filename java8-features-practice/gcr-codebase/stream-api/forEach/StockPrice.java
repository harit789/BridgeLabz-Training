import java.util.Arrays;
import java.util.List;

public class StockPrice {
	public static void main(String[] args) {
		List<Double> stock = Arrays.asList(255.0, 444.0, 343.0, 232.0, 997.0);
		stock.stream().forEach(price -> System.out.println("Stock price updates : $" + price));
	}
}
