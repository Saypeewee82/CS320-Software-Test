// Peter Saye
// 9/15/2026
// CS 320 Module 3 Contact Service

package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddingContact() {
		ContactService service = new ContactService();
		service.addContact(new Contact("2784946", "Peter", "Saye", "1111111111", "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> service.addContact(new Contact("2784946", "Christina", "Reynolds", "2222222222", "Davenport")));
	}

	@Test
	void testDeletingContact() {
		ContactService service = new ContactService();
		service.addContact(new Contact("2784946", "Peter", "Saye", "1111111111", "Orlando"));
		service.deleteContact("2784946");
		service.addContact(new Contact("2784947", "Christina", "Reynolds", "2222222222", "Davenport"));
	}

	@Test
	void testUpdatingContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("2784946", "Peter", "Saye", "1111111111", "Orlando");
		service.addContact(contact);
		service.updateFirstName("2784946", "Christina");
		service.updateLastName("2784946", "Reynolds");
		service.updatePhone("2784946", "2222222222");
		service.updateAddress("2784946", "Davenport");
		assertEquals("2784946", contact.getContactId());
		assertEquals("Christina", contact.getFirstName());
		assertEquals("Reynolds", contact.getLastName());
		assertEquals("2222222222", contact.getPhone());
		assertEquals("Davenport", contact.getAddress());
	}
}
