import java.util.HashMap;

public class NumberOfGoodPairs {
	
	class Solution {
		public int numIdenticalPairs(int[] nums) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int result = 0;
			for (int num : nums) {
				int freq = map.getOrDefault(num, 0);
				result += freq;
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			return result;
		}
	}
}
