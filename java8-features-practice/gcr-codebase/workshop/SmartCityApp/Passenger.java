package workshop.SmartCityApp;

public class Passenger {
    private String name;
    private String route;
    private double fare;
    private boolean peakHour;

    public Passenger(String name, String route, double fare, boolean peakHour) {
        this.name = name;
        this.route = route;
        this.fare = fare;
        this.peakHour = peakHour;
    }

    public String getRoute() {
        return route;
    }

    public double getFare() {
        return fare;
    }

    public boolean isPeakHour() {
        return peakHour;
    }
}
