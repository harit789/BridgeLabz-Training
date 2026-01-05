package reviews;

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first String : ");
		String a = sc.next();
		System.out.print("Enter second String : ");
		String b = sc.next();
		boolean isAna = isAnagram(a,b);
		if(isAna) {
			System.out.println("Anagram");
		}  else {
			System.out.println(" Valid Anagram");
		}
		
	}
	public static boolean isAnagram(String a , String b) {
		if(a.length() != b.length()) return false;
		char[] a1  = a.toCharArray();
		char[] b2 = b.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(b2);
		return Arrays.equals(a1,b2);
	}
}

