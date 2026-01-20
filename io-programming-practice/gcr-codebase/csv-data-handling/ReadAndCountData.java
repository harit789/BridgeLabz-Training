import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountData {
	public static void main(String args[]) {
		try (BufferedReader br = new BufferedReader(new FileReader("WriteStudents.csv"))) {
			int count = 0;
			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				System.out.println("Id : " + columns[0] + " Name : " + columns[1] + " Department" + columns[2]
						+ " Salary : " + columns[3]);
				count++;
			}
			System.out.println("Number of Records" + count);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
