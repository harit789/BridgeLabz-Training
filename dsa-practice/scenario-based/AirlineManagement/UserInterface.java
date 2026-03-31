package AirlineManagement;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil();

        try {
            System.out.println(
                "Enter flight details in the format <FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuelLevel>"
            );

            String input = sc.nextLine();

            String[] details = input.split(":");

            String flightNumber = details[0];
            String flightName = details[1];
            int passengerCount = Integer.parseInt(details[2]);
            double currentFuelLevel = Double.parseDouble(details[3]);

            flightUtil.validateFlightNumber(flightNumber);
            flightUtil.validateFlightName(flightName);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double fuelToFill =
                    flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println(
                "Fuel required to fill the tank: " + fuelToFill + " liters"
            );

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input format");
        }
    }
}
