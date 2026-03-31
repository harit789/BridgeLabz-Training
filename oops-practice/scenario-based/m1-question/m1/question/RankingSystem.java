package question;

import java.util.*;

class Student {
	String studentName;
	String department;
	int quiz1;
	int quiz2;
	int quiz3;

	public Student(String studentName, String department, int quiz1, int quiz2, int quiz3) {
		this.studentName = studentName;
		this.department = department;
		this.quiz1 = quiz1;
		this.quiz2 = quiz2;
		this.quiz3 = quiz3;
	}

	public int total() {
		return quiz1 + quiz2 + quiz3;
	}
}

public class RankingSystem {
	private List<Student> list = new ArrayList<>();

	public void addStudent(Student student) {
		list.add(student);
	}

	public static void main(String[] args) {
		RankingSystem util = new RankingSystem();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str[] = new String[n];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}
		List<String> quizes = List.of("Q1", "Q2", "Q3");
		for (String s : str) {
			String[] inputArr = s.split("\\s+");
			if (inputArr[0].equals("Record")) {
				Student student = new Student(inputArr[1], inputArr[2], Integer.parseInt(inputArr[3]),
						Integer.parseInt(inputArr[4]), Integer.parseInt(inputArr[5]));
				util.addStudent(student);
				System.out.println("Record Added :" + student.studentName);
			} else if (inputArr[0].equals("Top")) {
				if (quizes.contains(inputArr[1])) {
					int max = Integer.MIN_VALUE;
					for(Student student: util.list) {
						if(inputArr[1].equals("Q1")) {
							max = Math.max(max, student.quiz1);
						}
						
						if(inputArr[1].equals("Q2")) {
							max = Math.max(max, student.quiz2);
						}
						
						if(inputArr[1].equals("Q3")) {
							max = Math.max(max, student.quiz3);
						}
					}
					
					for(Student student : util.list) {
						if(inputArr[1].equals("Q1") && student.quiz1 == max||
								inputArr[1].equals("Q2") && student.quiz2 == max||
								inputArr[1].equals("Q3") && student.quiz3 == max) {
							System.out.println(student.studentName + " " + max);
						}
					}
				}
			} else {
				int max = Integer.MIN_VALUE;
				for (Student student : util.list) {
					if (student.department.equals(inputArr[1])) {
						max = Math.max(max, student.total());
					}
				}

				for (Student student : util.list) {
					if (student.total() == max) {
						System.out.println(student.studentName + " " + max);
					}
				}
			}
		}
	}
}
