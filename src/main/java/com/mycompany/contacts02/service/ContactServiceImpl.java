package com.mycompany.contacts02.service;

import com.mycompany.contacts02.entity.Contact;
import com.mycompany.contacts02.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(Contact c) {
        return contactRepository.saveAndFlush(c);
    }

    @Override
    public void deleteContact(long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact editContact(Contact c) {
        return addContact(c);
    }

    @Override
    public Contact getContact(long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> getAllContactsByLastName(String name) {
        return contactRepository.findAllContactsByLastName(name);
    }

    @Override
    public List<Contact> getAllContactsByFirstName(String name) {
        return contactRepository.findAllContactsByFirstName(name);
    }

    @Override
    public List<Contact> getAllContactsByPhone(String phone) {
        return contactRepository.getAllContactsByPhone(phone);
    }

    @Override
    public List<Contact> getAllContactsByEmail(String email) {
        return contactRepository.getAllContactsByEmail(email);
    }
}
