package AirlineManagement;

public class InvalidFlightException extends Exception {
	String message;

	public InvalidFlightException(String message) {
		super(message);
	}
}