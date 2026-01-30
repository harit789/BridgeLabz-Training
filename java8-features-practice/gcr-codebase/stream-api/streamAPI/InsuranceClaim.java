
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim {
	String claimType;
	double claimAmount;

	public Claim(String claimType, double claimAmount) {
		this.claimType = claimType;
		this.claimAmount = claimAmount;
	}
}

public class InsuranceClaim {
	public static void main(String[] args) {
		List<Claim> claims = new ArrayList<>();
		claims.add(new Claim("Health", 5000));
		claims.add(new Claim("Vehicle", 12000));
		claims.add(new Claim("Health", 8000));
		claims.add(new Claim("Life", 20000));
		claims.add(new Claim("Vehicle", 10000));
		claims.add(new Claim("Life", 30000));

		Map<String, Double> result = claims.stream()
				.collect(Collectors.groupingBy(c -> c.claimType, Collectors.averagingDouble(c -> c.claimAmount)));

		result.forEach((key, value) -> System.out.println(key + " -> " + value));

	}
}
