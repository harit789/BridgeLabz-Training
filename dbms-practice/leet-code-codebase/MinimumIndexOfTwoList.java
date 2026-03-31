import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexOfTwoList {

	class Solution {
		public String[] findRestaurant(String[] list1, String[] list2) {
			List<String> newList1 = Arrays.asList(list1);
			List<String> newList2 = Arrays.asList(list2);

			HashMap<String, Integer> map = new HashMap<>();
			int min = Integer.MAX_VALUE;
			for (String str : newList1) {
				if (newList2.contains(str)) {
					int i = newList1.indexOf(str);
					int j = newList2.indexOf(str);
					min = Math.min((i + j), min);
					map.put(str, i + j);
				}
			}

			List<String> result = new ArrayList<>();

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() == min) {
					result.add(entry.getKey());
				}
			}
			return result.toArray(new String[0]);
		}
	}
}
