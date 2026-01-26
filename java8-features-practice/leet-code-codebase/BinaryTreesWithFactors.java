import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {
	class Solution {
		int MOD = (int) 1e9 + 7;

		public int numFactoredBinaryTrees(int[] arr) {
			Arrays.sort(arr);
			int n = arr.length;

			HashMap<Integer, Long> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				map.put(arr[i], 1L);

				for (int j = 0; j < i; j++) {
					int left = arr[j];

					if (arr[i] % left == 0) {
						int right = arr[i] / left;

						if (map.containsKey(right)) {
							long ways = (map.get(left) * map.get(right)) % MOD;
							map.put(arr[i], (map.get(arr[i]) + ways) % MOD);
						}
					}
				}
			}

			long result = 0;
			for (long val : map.values()) {
				result = (result + val) % MOD;
			}

			return (int) result;
		}
	}
}
