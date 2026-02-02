
public class TaxiService {
	private String isAvailaible;
	private String destination;
	private String departure;
	private String departureTime;
	private String arrivalTime;

	public TaxiService(String isAvailaible, String destination, String departure, String departureTime,
			String arrivalTime) {
		super();
		this.isAvailaible = isAvailaible;
		this.destination = destination;
		this.departure = departure;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getIsAvailaible() {
		return isAvailaible;
	}

	public void setIsAvailaible(String isAvailaible) {
		this.isAvailaible = isAvailaible;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "TaxiService [isAvailaible=" + isAvailaible + ", destination=" + destination + ", departure=" + departure
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}

}
