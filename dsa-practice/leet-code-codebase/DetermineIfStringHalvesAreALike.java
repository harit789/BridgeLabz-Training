public class DetermineIfStringHalvesAreAlike {
	class Solution {
		public boolean halvesAreAlike(String s) {
			int half = s.length() / 2;
			String vowels = "aeiouAEIOU";
			int right = 0;
			int left = 0;
			for (int i = 0; i < half; i++) {
				if (vowels.indexOf(s.charAt(i)) != -1) {
					right++;
				}
			}

			for (int i = half; i < s.length(); i++) {
				if (vowels.indexOf(s.charAt(i)) != -1) {
					left++;
				}
			}
			return left == right;
		}
	}
}