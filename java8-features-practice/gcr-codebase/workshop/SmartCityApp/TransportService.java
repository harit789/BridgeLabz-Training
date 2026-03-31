package workshop.SmartCityApp;

public interface TransportService {

	String getServiceName();

	String getDeparture();

	String getDestination();

	String getDepartureTime();

	boolean isAvailable();

	default void printServiceDetails() {
		System.out.println(getServiceName() + " | From: " + getDeparture() + " | To: " + getDestination() + " | Time: "
				+ getDepartureTime());
	}
}
