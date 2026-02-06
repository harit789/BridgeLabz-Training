import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {

	public static void main(String[] args) {

		String fileName = "input.txt";
		HashMap<String, Integer> wordCount = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;

			while ((line = br.readLine()) != null) {

				line = line.toLowerCase().replaceAll("[^a-z ]", "");

				String[] words = line.split("\\s+");

				for (String word : words) {
					if (!word.isEmpty()) {
						wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
					}
				}
			}

		} catch (IOException e) {
			System.out.println("File reading error: " + e.getMessage());
			return;
		}

		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());

		sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

		int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
		System.out.println("Total Words: " + totalWords);

		System.out.println("\nTop 5 Most Frequent Words:");
		for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
			Map.Entry<String, Integer> entry = sortedList.get(i);
			System.out.println((i + 1) + ". " + entry.getKey() + " → " + entry.getValue());
		}
	}
}
