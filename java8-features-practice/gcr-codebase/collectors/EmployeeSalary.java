import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	private String department;
	private double salary;

	public Employee(String department, double salary) {
		this.department = department;
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalary {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("HR", 35000.0));
		employees.add(new Employee("IT", 67000.0));
		employees.add(new Employee("CIVIL", 24000.0));
		Map<String, Double> avgSalaryByDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		avgSalaryByDept.forEach((department, salary) -> System.out.println(department + " -> " + salary));
	}
}
