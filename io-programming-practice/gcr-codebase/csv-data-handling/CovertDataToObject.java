import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Student{
	int id;
	String name;
	int age;
	int marks;
	
	public Student(int id, String name, int age, int marks) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", Age : " + age + ", Marks : " + marks;
	}
}
public class CovertDataToObject {
	public static void main(String args[]) {
		ArrayList<Student> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("student.csv"))){
			String line;
			while((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				int id = Integer.parseInt(columns[0]);
				String name = columns[1];
				int age = Integer.parseInt(columns[2]);
				int marks = Integer.parseInt(columns[3]);
				
				list.add(new Student(id, name, age, marks));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Student s : list) {
			System.out.println(s);
		}
	}
}
