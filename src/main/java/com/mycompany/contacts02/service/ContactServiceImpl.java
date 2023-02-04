package com.mycompany.contacts02.service;

import com.mycompany.contacts02.entity.Contact;
import com.mycompany.contacts02.repository.ContactRepository;
import com.mycompany.contacts02.service.ContactService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

//    public ContactServiceImpl() {
//    }
//    public ContactServiceImpl(ContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }
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
//        List<Contact> contacts = new ArrayList<>();
//         contactRepository.findAll()
//               .forEach(contacts::add);
//       return contacts;
        return contactRepository.findAll();
    }

    @Override
    public Contact editContact(Contact c) {
        return addContact(c);
    }

//    @Override
//    public List<Contact> getAllContactsByFirstNameAndLastName(String name1, String name2) {
//        return contactRepository.findAllContactsByFirstNameAndLastName(name1, name2);
//    }
    @Override
    public Contact getContact(long id) {
//        Optional<Contact> opt = contactRepository.findById(id);
//    return opt == null ? null : opt.get();
        return contactRepository.findById(id);
    }
}
