package AirlineManagement;

import java.util.Arrays;
import java.util.List;

public class FlightUtil {

	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
		boolean isValid = flightNumber.matches("FL-[1-9][0-9]{3}");
		if (!isValid) {
			throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
		} else {
			return true;
		}
	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {

	    List<String> avlFlight = Arrays.asList(
	            "SpiceJet", "Vistara", "IndiGo", "Air Arabia"
	    );

	    boolean isValid = false;

	    for (String flight : avlFlight) {
	        if (flight.equalsIgnoreCase(flightName)) {
	            isValid = true;
	            break;
	        }
	    }

	    if (!isValid) {
	        throw new InvalidFlightException(
	            "The flight name " + flightName + " is invalid"
	        );
	    }

	    return true;
	}


	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {

		int maxCapacity;

		switch (flightName.toLowerCase()) {
		case "spicejet":
			maxCapacity = 396;
			break;
		case "vistara":
			maxCapacity = 615;
			break;
		case "indigo":
			maxCapacity = 230;
			break;
		case "air arabia":
			maxCapacity = 130;
			break;
		default:
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}

		if (passengerCount <= 0 || passengerCount > maxCapacity) {
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		return true;
	}

	

	public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double maxFuel;

        switch (flightName.toLowerCase()) {
            case "spicejet":
                maxFuel = 200000;
                break;
            case "vistara":
                maxFuel = 300000;
                break;
            case "indigo":
                maxFuel = 250000;
                break;
            case "air arabia":
                maxFuel = 150000;
                break;
            default:
                throw new InvalidFlightException(
                    "Invalid fuel level for " + flightName
                );
        }

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException(
                "Invalid fuel level for " + flightName
            );
        }

        return maxFuel - currentFuelLevel;
    }

}
