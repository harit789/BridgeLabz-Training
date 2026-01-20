import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	public static void main(String[] args) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("employee.csv"))) {
			bw.write("Id,Name,Department,Salary\n");
			bw.write("101,pandey,CSE,50000\n");
			bw.write("102,himanshu,Mechnical,17000\n");
			bw.write("103,kumar,Civil,60000\n");
			bw.write("104,diyom,CSE,99000\n");
			bw.write("105,dev,EC,59000\n");
			System.out.println("File Write Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
