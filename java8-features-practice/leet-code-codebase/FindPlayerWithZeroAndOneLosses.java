import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPlayerWithZeroAndOneLosses {

	class Solution {

		public List<List<Integer>> findWinners(int[][] matches) {

			HashMap<Integer, Integer> lossCount = new HashMap<>();
			Set<Integer> players = new HashSet<>();
			int winner;
			int loser;
			for (int[] match : matches) {
				winner = match[0];
				loser = match[1];

				players.add(winner);
				players.add(loser);

				lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
			}

			List<Integer> neverLost = new ArrayList<>();
			List<Integer> oneLost = new ArrayList<>();

			for (int player : players) {
				int losses = lossCount.getOrDefault(player, 0);
				if (losses == 0) {
					neverLost.add(player);
				} else if (losses == 1) {
					oneLost.add(player);
				}
			}

			Collections.sort(neverLost);
			Collections.sort(oneLost);

			return List.of(neverLost, oneLost);
		}
	}
}
