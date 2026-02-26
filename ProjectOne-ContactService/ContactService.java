package com.snhu.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(id, contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null || contactId.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null/empty.");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        getExisting(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getExisting(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getExisting(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getExisting(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    private Contact getExisting(String contactId) {
        if (contactId == null || contactId.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be null/empty.");
        }
        Contact c = contacts.get(contactId);
        if (c == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return c;
    }
}
