import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
	public static void main(String args[]) {
		String para = "Nothing starts with n end with g";
		Map<String, Integer> wordCount = Arrays.stream(para.split("\\s+"))
				.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
		
		wordCount.forEach((word, count) -> System.out.println(word + " -> " + count));
	}
}
