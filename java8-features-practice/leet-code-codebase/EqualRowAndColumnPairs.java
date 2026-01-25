import java.util.HashMap;

public class EqualRowAndColumnPairs {

	class Solution {
		public int equalPairs(int[][] grid) {

			int res = 0;
			HashMap<String, Integer> map = new HashMap<>();

			for (int[] row : grid) {
				StringBuilder sb = new StringBuilder();
				for (int n : row) {
					sb.append(n + ",");
				}
				map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			}

			for (int i = 0; i < grid.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < grid[0].length; j++) {
					sb.append(grid[j][i] + ",");
				}
				res += map.getOrDefault(sb.toString(), 0);
			}
			return res;
		}
	}
}
