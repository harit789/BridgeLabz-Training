import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
	private String name;
	private String grade;

	public Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}
}

public class StudentResultGrouping {
	public static void main(String args[]) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("harsh", "A"));
		list.add(new Student("kunal", "B"));
		list.add(new Student("shivam", "B"));
		list.add(new Student("rishabh", "A+"));

		Map<String, List<String>> map = list.stream().collect(
				Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));

		map.forEach((grade, names) -> System.out.println(grade + " : " + names));
	}
}
