
import java.util.Scanner;

public class SentenceForamtter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String result = sentenceFormatter(str);
		System.out.println(result);
	}

	public static String sentenceFormatter(String str) {
		str = str.trim().replaceAll("\\s+", " ");
		StringBuilder sb = new StringBuilder();
		boolean isCapital = true;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				if (isCapital) {
					sb.append(Character.toUpperCase(ch));
					isCapital = false;
				} else {
					sb.append(Character.toLowerCase(ch));
				}
			}

			else if (ch == '.' || ch == '!' || ch == '?') {
				sb.append(ch);
				sb.append(" ");
				isCapital = true;
			}

			else if (ch == ',') {
				sb.append(ch);
				sb.append(" ");
			}

			else if (ch == ' ') {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
					sb.append(" ");
				}
			}
		}
		String result = sb.toString().trim();
		return result;
	}
}
