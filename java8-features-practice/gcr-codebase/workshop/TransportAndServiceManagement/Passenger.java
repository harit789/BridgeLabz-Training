public class Passenger {
	private String name;
	private String contact;

	public Passenger(String name, String contact) {
		this.name = name;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Passenger [Name : " + name + " , Contact : " + contact + " ]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}