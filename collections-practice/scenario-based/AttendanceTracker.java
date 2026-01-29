import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Student {
	String studentId;

	public Student(String studentId) {
		this.studentId = studentId;
	}
}

class DuplicateAttendanceException extends Exception {
	String message;

	public DuplicateAttendanceException(String message) {
		super(message);
	}
}

public class AttendanceTracker {
	HashMap<String, Set<String>> map = new HashMap<>();

	public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
		map.putIfAbsent(sessionId, new HashSet<>());

		Set<String> students = map.get(sessionId);

		if (students.contains(studentId)) {
			throw new DuplicateAttendanceException(
					"Attendace already marked for that student " + studentId + " in session " + sessionId);
		}

		students.add(studentId);
	}

	public void removeAttendance(String sessionId, String studentId) {
		if (map.containsKey(sessionId)) {
			Set<String> students = map.get(sessionId);
			if (students.contains(studentId)) {
				students.remove(studentId);
				System.out.println("Student Removed");
			} else {
				System.out.println("Student Not found");
			}
		} else {
			System.out.println("Session not found");
		}
	}

	public void displayAttendance() {
		System.out.println("--------Attendance Sheet------");
		System.out.println("SessionId   :   StudentId");
		for (String key : map.keySet()) {
			Set<String> students = map.get(key);
			for (String student : students) {
				System.out.println(key + "           :     " + student);
			}
		}

	}

	public static void main(String args[]) {
		AttendanceTracker tracker = new AttendanceTracker();

		try {
			tracker.markAttendance("X", "101");
			tracker.markAttendance("X", "102");
			tracker.markAttendance("X", "101"); // exception
		} catch (DuplicateAttendanceException e) {
			System.out.println(e.getMessage());
		}

		tracker.displayAttendance();
	}

}
