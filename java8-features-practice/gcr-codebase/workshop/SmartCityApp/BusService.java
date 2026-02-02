package workshop.SmartCityApp;

public class BusService implements TransportService {

    private boolean available;
    private String departure;
    private String destination;
    private String departureTime;

    public BusService(boolean available, String departure, String destination, String departureTime) {
        this.available = available;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getServiceName() {
        return "Bus Service";
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public boolean isAvailable() {
        return available;
    }
}
