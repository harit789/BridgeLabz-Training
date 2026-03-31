import java.util.ArrayList;
import java.util.List;

class Patient{
	int patientId;
	String patientName;
	
	public Patient(int patientId, String patientName) {
		this.patientId = patientId;
		this.patientName = patientName;
	}
	
	public String toString() {
		return "Pateint [ Id : " + patientId + ", Name : " + patientName + " ]"; 
	}
	
	public void printId() {
		System.out.println("Patient Id : " +patientId);
	}
	
}
public class HospitalPatient {
	public static void main(String[] args) {
		List<Patient> list = new ArrayList<>();
		
		list.add(new Patient(101, "Mang"));
		list.add(new Patient(102, "Tush"));
		list.add(new Patient(103, "Rish"));
		list.add(new Patient(104, "Ram"));
		list.add(new Patient(105, "Tul"));
		
		
		list.forEach(Patient::printId);
	}
}
