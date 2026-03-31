import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlipKey {
	public static String CleanseAndInvert(String input) {

		// CHECKING INPUT FORMAT
		if (input.length() < 6) {
			return "Invalid Input";
		}

		String regex = "[a-zA-Z]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		boolean matches = matcher.matches();
		if (!matches) {
			return "Invalid Input";
		}

		// REMOVING CHAR HAVING EVEN ASCII VALUE
		input = input.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (char ch : input.toCharArray()) {
			int ascii = ch - '0';
			if (ascii % 2 != 0) {
				sb.append(ch);
			}
		}

		// REVERSE STRING
		String newString = sb.toString();
		StringBuilder revString = new StringBuilder();
		for (int i = newString.length() - 1; i >= 0; i--) {
			revString.append(newString.charAt(i));
		}

		// Capitalise even place characters
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < revString.length(); i++) {
			char ch = revString.charAt(i);
			if (i % 2 == 0) {
				char cap = (char) (ch - 32);
				result.append(cap);
			} else {
				result.append(ch);
			}
		}
		return result.toString();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String input = sc.nextLine();
		String result = CleanseAndInvert(input);
		System.out.println("The generated key is - " + result);

	}
}
