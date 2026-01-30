import java.util.Arrays;
import java.util.List;

public class SensorReadings {
	public static void main(String args[]) {
		List<Double> readings = Arrays.asList(23.2, 43.4, 11.5, 34.5, 54.6);
		double threshold = 30.0;
		readings.stream().filter(reading -> reading > threshold).forEach(System.out::println);
	}
}
