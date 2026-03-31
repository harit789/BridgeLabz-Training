import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	int id;
	String name;
	String department;
	double salary;

	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
	}
}

public class EmployeeSerialization {

	static final String FILE_NAME = "employees.dat";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Employee> employeeList = new ArrayList<>();

		System.out.print("Enter number of employees: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details for Employee " + (i + 1));

			System.out.print("ID: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Department: ");
			String department = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			employeeList.add(new Employee(id, name, department, salary));
		}

		// 🔹 Serialization
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

			oos.writeObject(employeeList);
			System.out.println("\nEmployees serialized successfully.");

		} catch (IOException e) {
			System.out.println("Serialization error: " + e.getMessage());
		}

		// 🔹 Deserialization
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

			List<Employee> employees = (List<Employee>) ois.readObject();

			System.out.println("\nEmployee Details (After Deserialization):");
			for (Employee emp : employees) {
				System.out.println(emp);
			}

		} catch (IOException e) {
			System.out.println("IO error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: " + e.getMessage());
		}

		sc.close();
	}
}
