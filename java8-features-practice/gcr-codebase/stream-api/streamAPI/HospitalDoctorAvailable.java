
import java.util.ArrayList;
import java.util.List;

class Doctor {
	String doctorName;
	boolean onWeekend;

	public Doctor(String doctorName, boolean onWeekend) {
		this.doctorName = doctorName;
		this.onWeekend = onWeekend;
	}

	public String toString() {
		return "Doctor [ Name : " + doctorName + " ,  Is available : " + onWeekend + " ]";
	}
}

public class HospitalDoctorAvailable {
	public static void main(String args[]) {
		List<Doctor> list = new ArrayList<>();
		list.add(new Doctor("ales", true));
		list.add(new Doctor("flox", false));
		list.add(new Doctor("bob", true));
		list.add(new Doctor("alice", true));
		list.add(new Doctor("mac", true));
		list.add(new Doctor("dose", false));

		list.stream().filter(d -> d.onWeekend).sorted((d1, d2) -> d1.doctorName.length() - d2.doctorName.length()).forEach(System.out::println);
	}
}
