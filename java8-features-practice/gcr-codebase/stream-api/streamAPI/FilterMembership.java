
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Member {
	String name;
	LocalDate date;

	public Member(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}

	public String toString() {
		return "Membershhip [ name : " + name + " , Expiry Date : " + date + " ]";
	}
}

public class FilterMembership {
	public static void main(String args[]) {
		List<Member> members = new ArrayList<>();
		members.add(new Member("Raj", LocalDate.now().plusDays(10)));
		members.add(new Member("Amit", LocalDate.now().plusDays(40)));
		members.add(new Member("Neha", LocalDate.now().plusDays(25)));
		members.add(new Member("Kiran", LocalDate.now().plusDays(50)));

		LocalDate today = LocalDate.now();
		LocalDate next30Days = today.plusDays(30);

		members.stream().filter(m -> !m.date.isAfter(next30Days)).forEach(System.out::println);
	}
}
