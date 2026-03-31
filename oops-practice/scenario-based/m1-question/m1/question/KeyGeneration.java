package question;

import java.util.*;

public class KeyGeneration {

	public static boolean isAlpha(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	public static void processString(String s) {

		if (s.length() == 0) {
			System.out.println("Invalid Input (empty string)");
			return;
		}

		if (s.length() < 6) {
			System.out.println("Invalid Input (length < 6)");
			return;
		}

		if (s.contains(" ")) {
			System.out.println("Invalid Input (contains space)");
			return;
		}

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				System.out.println("Invalid Input (contains digits)");
				return;
			}
		}

		if (!isAlpha(s)) {
			System.out.println("Invalid Input (contains special character)");
			return;
		}

		s = s.toLowerCase();

		StringBuilder filtered = new StringBuilder();
		for (char c : s.toCharArray()) {
			if ((int) c % 2 != 0) {
				filtered.append(c);
			}
		}

		filtered.reverse();

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < filtered.length(); i++) {
			char c = filtered.charAt(i);
			if (i % 2 == 0) {
				result.append(Character.toUpperCase(c));
			} else {
				result.append(c);
			}
		}

		System.out.println("The generated key is - " + result.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			processString(input);
		}

	}
}