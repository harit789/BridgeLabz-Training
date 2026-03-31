package src.test.java.com.training.AddressBook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

	private AddressBook addressBook;

	@BeforeEach
	void setUp() {
		addressBook = new AddressBook();
	}

	@Test
	void testAddContact() {
		Contact contact = new Contact();
		contact.setFirstName("John");
		contact.setLastName("Doe");

		addressBook.addContact(contact);

		assertEquals(1, addressBook.getContactList().size());
	}

	@Test
	void testDuplicateContactNotAdded() {

		Contact c1 = new Contact();
		c1.setFirstName("John");
		c1.setLastName("Doe");

		Contact c2 = new Contact();
		c2.setFirstName("John");
		c2.setLastName("Doe");

		addressBook.addContact(c1);
		addressBook.addContact(c2); // Duplicate

		assertEquals(1, addressBook.getContactList().size());
	}

	@Test
	void testDeleteContact() {

		Contact contact = new Contact();
		contact.setFirstName("John");
		contact.setLastName("Doe");

		addressBook.addContact(contact);
		addressBook.deleteContact("John");

		assertEquals(0, addressBook.getContactList().size());
	}

	@Test
	void testSortByName() {

		Contact c1 = new Contact();
		c1.setFirstName("Zara");

		Contact c2 = new Contact();
		c2.setFirstName("Anya");

		addressBook.addContact(c1);
		addressBook.addContact(c2);

		addressBook.sortByName();

		assertEquals("Anya", addressBook.getContactList().get(0).getFirstName());
	}
}
