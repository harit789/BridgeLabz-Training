import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class SortRecord {
	public static void main(String[] args) {
		ArrayList<String[]> records = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("employee.csv"))){
			String line;
			while((line = br.readLine()) != null) {
				records.add(line.split(","));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(records, (a, b) -> Integer.compare(Integer.parseInt(b[3].trim()), Integer.parseInt(a[3].trim())));
		
		System.out.println("Top 5 Highest-paid Employees");
		for(int i = 0; i < Math.min(5, records.size()); i++) {
			String[] r = records.get(i);
			System.out.println("Id : " + r[0] + ", Name : " + r[1] + ", Department : " +r[2] + ", Salary : "  + r[3]);
		}
	}
}
