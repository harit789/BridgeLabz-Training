import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String paragraph = sc.nextLine();
        paragraph = normalizeSpaces(paragraph);

        if (paragraph.isEmpty()) {
            System.out.println("Paragraph is empty.");
            return;
        }

        String[] words = splitWords(paragraph);

        printWordCount(words);
        printLongestWord(words);

        String oldWord = sc.next();
        String newWord = sc.next();

        String updatedParagraph = replaceWord(words, oldWord, newWord);
        System.out.println(updatedParagraph);
    }

    private static String normalizeSpaces(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }

    private static String[] splitWords(String text) {
        return text.split(" ");
    }

    private static void printWordCount(String[] words) {
        System.out.println("total number of words : " + words.length);
    }

    private static void printLongestWord(String[] words) {
        int maxLength = 0;
        String maxWord = "";

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                maxWord = word;
            }
        }

        System.out.println("Word of max length : " + maxWord);
    }

    private static String replaceWord(String[] words, String oldWord, String newWord) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.equalsIgnoreCase(oldWord)) {
                sb.append(newWord);
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
