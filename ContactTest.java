// Peter Saye
// 9/15/2026
// CS 320 Module 3 Contact Service

package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("2784946", "Peter", "Saye", "1111111111", "Orlando");
		assertEquals("2784946", contact.getContactId());
		assertEquals("Peter", contact.getFirstName());
		assertEquals("Saye", contact.getLastName());
		assertEquals("1111111111", contact.getPhone());
		assertEquals("Orlando", contact.getAddress());
	}

	@Test
	void testLongestAllowedValues() {
		Contact contact = new Contact("1111111111", "1111111111", "1111111111", "1111111111",
				"111111111111111111111111111111");
		assertEquals(10, contact.getContactId().length());
		assertEquals(10, contact.getFirstName().length());
		assertEquals(10, contact.getLastName().length());
		assertEquals(30, contact.getAddress().length());
	}

	@Test
	void testInvalidContactIds() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Peter", "Saye", "1111111111", "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("11111111111", "Peter", "Saye", "1111111111", "Orlando"));
	}

	@Test
	void testInvalidFirstNames() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", null, "Saye", "1111111111", "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "11111111111", "Saye", "1111111111", "Orlando"));
	}

	@Test
	void testInvalidLastNames() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "Peter", null, "1111111111", "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "Peter", "11111111111", "1111111111", "Orlando"));
	}

	@Test
	void testInvalidPhoneNumbers() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("2784946", "Peter", "Saye", null, "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "Peter", "Saye", "111111111", "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "Peter", "Saye", "11111111111", "Orlando"));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "Peter", "Saye", "xxxxxxxxxx", "Orlando"));
	}

	@Test
	void testInvalidAddresses() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("2784946", "Peter", "Saye", "1111111111", null));
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("2784946", "Peter", "Saye", "1111111111", "1111111111111111111111111111111"));
	}

	@Test
	void testUpdatingContact() {
		Contact contact = new Contact("2784946", "Peter", "Saye", "1111111111", "Orlando");
		contact.setFirstName("Christina");
		contact.setLastName("Reynolds");
		contact.setPhone("2222222222");
		contact.setAddress("Davenport");
		assertEquals("2784946", contact.getContactId());
		assertEquals("Christina", contact.getFirstName());
		assertEquals("Reynolds", contact.getLastName());
		assertEquals("2222222222", contact.getPhone());
		assertEquals("Davenport", contact.getAddress());
	}

	@Test
	void testInvalidUpdates() {
		Contact contact = new Contact("2784946", "Peter", "Saye", "1111111111", "Orlando");
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("11111111111"));
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("11111111111"));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("111111111"));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("11111111111"));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("xxxxxxxxxx"));
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1111111111111111111111111111111"));
	}
}
