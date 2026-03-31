package question;

import java.util.List;
import java.util.Scanner;

public class Shipment {
	public static boolean checkShipCode(String code) {
		if (code.matches("SHIP-[1-9][0-9]{5}")) {
			String[] splitCode = code.split("\\-");
			String num = splitCode[1];
			int count = 1;
			for (int i = 1; i < num.length(); i++) {
				if (num.charAt(i - 1) == num.charAt(i)) {
					count++;
				} else {
					count = 1;
				}
				if (count > 3)
					return false;
			}
		}
		return false;

	}

	public static boolean checkShipment(String date) {
		if (date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
			String[] details = date.split("\\-");
			int year = Integer.parseInt(details[0]);
			int month = Integer.parseInt(details[1]);
			int day = Integer.parseInt(details[2]);

			if (year < 2000 || year > 2099) {
				return false;
			}

			if (month < 1 || month > 12) {
				return false;
			}

			if (day < 1 || day > 31) {
				return false;
			}

			if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 30) {
					return false;
				}
			}

			boolean isLeap = (year % 100 == 0) || (year % 4 == 0 && year % 100 != 0);
			if (isLeap) {
				if (month == 2 && day < 30) {
					return true;
				}
			}
		}
		return true;
	}

	public static boolean checkMode(String mode) {
		List<String> list = List.of("AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT");
		if (!list.contains(mode)) {
			return false;
		}
		return true;
	}

	public static boolean checkStatus(String status) {
		List<String> list = List.of("DELIVERED", "CANCELLED", "IN_TRANSIT");
		if (!list.contains(status)) {
			return false;
		}
		return true;
	}

	public static boolean checkWeight(String weight) {
		if (!weight.matches("[0-9]{1,6}\\.[0-9]{2}")) {
			return false;
		}
		
		double w = Double.parseDouble(weight);
		if(w < 0 || w > 999999.99) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] inputArr = new String[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			inputArr[i] = sc.nextLine();
		}

		for (int i = 0; i < inputArr.length; i++) {
			String[] details = inputArr[i].split("\\|");
			boolean check = checkShipCode(details[0]) && checkShipment(details[1]) && checkMode(details[2])
					&& checkWeight(details[3]) && checkStatus(details[4]);
			if (check) {
				System.out.println("NON-COMPLAINT RECORD");
			} else {
				System.out.println("COMPLAINT RECORD");
			}
		}
	}
}
