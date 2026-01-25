import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

	class Solution {
		public boolean wordPattern(String pattern, String s) {

			String[] words = s.split(" ");
			if (words.length != pattern.length())
				return false;
			HashMap<String, Character> map = new HashMap<>();
			HashSet<Character> set = new HashSet<>();
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				char ch = pattern.charAt(i);
				if (!map.containsKey(word) && !set.contains(ch)) {
					map.put(word, ch);
					set.add(ch);
				} else if (map.containsKey(word)) {
					if (map.get(word) != ch) {
						return false;
					}
				} else {
					return false;
				}
			}
			return true;
		}
	}
}
