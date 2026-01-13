package com.testing.Junit;

public class StringUtils {
	
	public String reverse(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}
		return reverse;
	}

	public boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public String toUpperCase(String str) {
		char[] ch = str.toCharArray();
		String result = "";
		for (char c : ch) {
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
			}
			result += c;
		}
		return result;
	}
}
