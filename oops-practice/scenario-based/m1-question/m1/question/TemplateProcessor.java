package question;

import java.util.*;

public class TemplateProcessor {
	public String checkString(String opr, String text) {
		if (opr.equals("UPPER")) {
			return text.toUpperCase();
		} else if (opr.equals("LOWER")) {
			return text.toLowerCase();
		} else if (opr.equals("REPEAT")) {
			String[] splitText = text.split("\\,");
			String word = splitText[0];
			int count = Integer.parseInt(splitText[1]);
			String str = word.repeat(count);
			return str;
		} else if (opr.equals("DATE")) {
			if (text.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
				String[] splitText = text.split("\\-");
				return splitText[2] + "/" + splitText[1] + "/" + splitText[0];
			} else {
				return "INVALID INPUT";
			}
		}
		return "";
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		TemplateProcessor util = new TemplateProcessor();
		int n = sc.nextInt();
		String[] inputArr = new String[n];
		sc.nextLine();
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = sc.nextLine();
		}

		for (String s : inputArr) {
			String[] inputSplit = s.split("\\s+");
			String sol = "";
			for (String str : inputSplit) {
				if (str.contains("${")) {
					String main = str.substring(2, str.length()-1);
					String[] mainSplit = main.split("\\:");
					String result = util.checkString(mainSplit[0], mainSplit[1]);
					sol += result + " ";
				} else {
					sol += str + " ";
				}
			}
			System.out.println(sol);
		}

	}
}
