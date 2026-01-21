import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DetectDuplicate {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				int id = Integer.parseInt(columns[0]);
				if (set.contains(id)) {
					System.out.println("Id : " + columns[0] + " Name : " + columns[1] + " Age : " + columns[2]
							+ " Marks : " + columns[3]);
				} else {
					set.add(id);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
