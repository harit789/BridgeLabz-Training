import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ModifyRecord {
	public static void main(String args[]) {
		try(BufferedReader br = new BufferedReader(new FileReader("employee.csv"))){
			String line;
			while((line = br.readLine()) != null){
				String[] columns = line.split(",");
				String department = "CS";
				if(department.equals(columns[2])){
					int salary = Integer.parseInt(columns[3]);
					salary = salary + (salary/10);
					columns[3] = String.valueOf(salary);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
