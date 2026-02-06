import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputToFile {

	public static void main(String[] args) {

		String fileName = "user_details.txt";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("Enter your name: ");
			String name = br.readLine();

			System.out.print("Enter your age: ");
			int age = Integer.parseInt(br.readLine());

			System.out.print("Enter your favorite programming language: ");
			String language = br.readLine();

			try (FileWriter fw = new FileWriter(fileName)) {
				fw.write("Name: " + name + "\n");
				fw.write("Age: " + age + "\n");
				fw.write("Favorite Programming Language: " + language + "\n");
			}

			System.out.println("\nUser information saved successfully.");

		} catch (IOException e) {
			System.out.println("Input/Output error: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Invalid age format.");
		}
	}
}
