import java.io.*;

public class StudentDataStreamDemo {

	public static void main(String[] args) {

		String fileName = "student.dat";

		int rollNo = 101;
		String name = "Alice";
		double gpa = 3.85;

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {

			dos.writeInt(rollNo);
			dos.writeUTF(name);
			dos.writeDouble(gpa);

			System.out.println("Student data written successfully.");

		} catch (IOException e) {
			System.out.println("Write error: " + e.getMessage());
			return;
		}

		try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {

			int r = dis.readInt();
			String n = dis.readUTF();
			double g = dis.readDouble();

			System.out.println("\nStudent Details (Retrieved):");
			System.out.println("Roll No: " + r);
			System.out.println("Name   : " + n);
			System.out.println("GPA    : " + g);

		} catch (IOException e) {
			System.out.println("Read error: " + e.getMessage());
		}
	}
}
