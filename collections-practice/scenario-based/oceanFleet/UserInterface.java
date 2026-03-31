package oceanFleet;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		VesselUtil vesselUtil = new VesselUtil();
		System.out.println("Enter number of vessel to be added :");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter Vessel details : ");
		String[] input = new String[n];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextLine();
		}
		System.out.println("Enter vessel id :");

		String setVesselId = sc.nextLine();
		for (String line : input) {
			String[] details = line.split(":");
			String vesselId = details[0];
			String vesselName = details[1];
			double avgSpeed = Double.parseDouble(details[2]);
			String vesselType = details[3];

			Vessel newVessel = new Vessel(vesselId, vesselName, avgSpeed, vesselType);
			vesselUtil.addVesselPerformance(newVessel);
		}
		try {
		Vessel getVesselById = vesselUtil.getVesselById(setVesselId);
		if (!getVesselById.equals(null)) {
			System.out.println(getVesselById);
		}
	} catch(NullPointerException e) {
			System.out.println("Vessel Id " + setVesselId + " not found");
		}
		
		

		System.out.println("High Perfomance vessels are : ");
		List<Vessel> highPerformanceList = vesselUtil.getHighPerformanceVessels();
		for (Vessel vessel : highPerformanceList) {
			System.out.println(vessel);
		}

	}
}
