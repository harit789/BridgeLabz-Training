import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraight {
	class Solution {
	    public boolean isNStraightHand(int[] hand, int groupSize) {
	        if (hand.length % groupSize != 0) return false;

	        HashMap<Integer, Integer> map = new HashMap<>();
	        Arrays.sort(hand);

	        for (int num : hand) {
	            map.put(num, map.getOrDefault(num, 0) + 1);
	        }

	        for (int num : hand) {
	            if (map.get(num) > 0) {
	                for (int i = 0; i < groupSize; i++) {
	                    int curr = num + i;
	                    if (map.getOrDefault(curr, 0) == 0) {
	                        return false;
	                    }
	                    map.put(curr, map.get(curr) - 1);
	                }
	            }
	        }
	        return true;
	    }
	}
}
