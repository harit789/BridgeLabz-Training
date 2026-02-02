package workshop.SmartCityApp;

public class MetroService implements TransportService {

    private boolean available;
    private String departure;
    private String destination;
    private String departureTime;

    public MetroService(boolean available, String departure, String destination, String departureTime) {
        this.available = available;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getServiceName() {
        return "Metro Service";
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
