// Peter Saye
// 9/15/2026
// CS 320 Module 3 Contact Service

package contact;

import java.util.HashMap;

public class ContactService {

	private final HashMap<String, Contact> contacts = new HashMap<>();

	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contacts.put(contact.getContactId(), contact);
	}

	public void deleteContact(String contactId) {
		contacts.remove(contactId);
	}

	public void updateFirstName(String contactId, String firstName) {
		contacts.get(contactId).setFirstName(firstName);
	}

	public void updateLastName(String contactId, String lastName) {
		contacts.get(contactId).setLastName(lastName);
	}

	public void updatePhone(String contactId, String phone) {
		contacts.get(contactId).setPhone(phone);
	}

	public void updateAddress(String contactId, String address) {
		contacts.get(contactId).setAddress(address);
	}
}
