public class DetectCapital {
	class Solution {
		public boolean detectCapitalUse(String word) {
			String isUpper = word.toUpperCase();
			String isLower = word.toLowerCase();
			String firstUpper = word.substring(0, 1).toUpperCase().concat(isLower.substring(1));
			return word.equals(isUpper) || word.equals(isLower) || word.equals(firstUpper);
		}
	}
}
