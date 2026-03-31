import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String args[]) {
		try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");

				System.out.println("Id : " + columns[0] + " Name : " + columns[1] + " Age : " + columns[2] + " Marks : "
						+ columns[3]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
