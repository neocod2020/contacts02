package com.mycompany.contacts02.repository;

import com.mycompany.contacts02.entity.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findById(long id);

    @Override
    List<Contact> findAll();

    List<Contact> findAllContactsByLastName(String name);

    List<Contact> findAllContactsByFirstName(String name);

    List<Contact> getAllContactsByPhone(String phone);

    List<Contact> getAllContactsByEmail(String email);
}
