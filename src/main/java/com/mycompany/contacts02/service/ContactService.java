package com.mycompany.contacts02.service;

import com.mycompany.contacts02.entity.Contact;
import java.util.List;

public interface ContactService {

    Contact addContact(Contact c);

    void deleteContact(long id);

    List<Contact> getAllContacts();

    Contact editContact(Contact c);

    Contact getContact(long id);

    List<Contact> getAllContactsByLastName(String name);

    List<Contact> getAllContactsByPhone(String phone);

    List<Contact> getAllContactsByEmail(String email);

}
