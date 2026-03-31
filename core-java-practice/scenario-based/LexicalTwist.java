import java.util.HashSet;
import java.util.Scanner;

public class LexicalTwist {

    public static String reverse(String str) {
        StringBuilder rev = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }
        return rev.toString();
    }

    public static void replaceStr(String str) {
        String vowels = "aeiou";
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                result.append("@");
            } else {
                result.append(ch);
            }
        }
        System.out.println(result);
    }
    
    public static int countVowel(String newStr) {
    	int count = 0;
    	String vowels = "AEIOU";
    	for(char ch : newStr.toCharArray()) {
    		if(vowels.indexOf(ch) != -1) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public static int countConsonant(String newStr) {
    	int count = 0;
    	String vowels = "AEIOU";
    	for(char ch : newStr.toCharArray()) {
    		if(vowels.indexOf(ch) == -1) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public static String moreVowels(String str) {
    	int temp = 0;
    	HashSet<Character> set = new HashSet<>();
    	String vowels = "AEIOU";
    	StringBuilder sb = new StringBuilder();
    	for(char ch : str.toCharArray()) {
    		if(vowels.indexOf(ch) != -1 ) {
    			if( !set.contains(ch) && temp < 2) {
    			set.add(ch);
    			sb.append(ch);
    			temp++;
    			} else if(temp > 2) break;
    		}
    	}
    	return sb.toString();
    }
    
    public static String moreConsonants(String str) {
    	int temp = 0;
    	HashSet<Character> set = new HashSet<>();
    	String vowels = "AEIOU";
    	StringBuilder sb = new StringBuilder();
    	for(char ch : str.toCharArray()) {
    		if(vowels.indexOf(ch) == -1 ) {
    			if( !set.contains(ch) && temp < 2) {
    			set.add(ch);
    			sb.append(ch);
    			temp++;
    			} else if(temp > 2) break;
    		} 
    	}
    	return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first word :");
        String str = sc.next();
        System.out.println("Enter the second word :");
        String revStr = sc.next();

        String rev = reverse(str);  

        if (rev.equals(revStr)) {     
            replaceStr(revStr.toLowerCase());
        } else {
        	String newStr = str.concat(revStr);
        	newStr = newStr.toUpperCase();
        	int countVowels = countVowel(newStr);
        	int countConsonants = countConsonant(newStr);
        	if(countVowels == countConsonants) {
        		System.out.println("Vowels and consonants are equal");
        	} else if(countVowels > countConsonants) {
        		System.out.println(moreVowels(newStr));
        	} else if(countVowels < countConsonants) {
        		System.out.println(moreConsonants(newStr))
;        	}
        }
    }
}
