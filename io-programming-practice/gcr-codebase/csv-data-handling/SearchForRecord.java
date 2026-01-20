import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchForRecord {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name :");
		String name = sc.next();
		try(BufferedReader br = new BufferedReader(new FileReader("employee.csv"))){
			String line;
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				if(name.equals(columns[1])) {
					System.out.println("Id : " + columns[0] + ", Name : " + columns[1] + ", Department : " + columns[2] + ", Salary : " + columns[3]);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
