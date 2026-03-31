package question;

import java.util.Scanner;

public class EmailControl {
	public static boolean validateMail(String input) {
		if (input.matches("[a-z]{3,}\\.[a-z]{3,}[0-9]{4,}\\@(sales|IT|marketing|product)\\.company\\.com")) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str[] = new String[n];
		sc.nextLine();
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}

		for (int i = 0; i < str.length; i++) {
			String mail = str[i];
			if(validateMail(mail)) {
				System.out.println("Acesses Granted");
			} else {
				System.out.println("Acess Failed");
			}
		}
	}
}
