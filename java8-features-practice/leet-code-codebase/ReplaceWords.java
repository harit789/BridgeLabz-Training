import java.util.HashSet;
import java.util.List;

public class ReplaceWords {
	class Solution {
		public String replaceWords(List<String> dictionary, String sentence) {
			HashSet<String> set = new HashSet<>(dictionary);
			StringBuilder sb = new StringBuilder();
			String[] newStr = sentence.split(" ");

			for (String word : newStr) {
				boolean isContain = false;

				for (int i = 1; i <= word.length(); i++) {
					if (set.contains(word.substring(0, i))) {
						sb.append(word.substring(0, i)).append(" ");
						isContain = true;
						break;
					}
				}

				if (!isContain) {
					sb.append(word).append(" ");
				}
			}

			return sb.toString().trim();
		}
	}

}
