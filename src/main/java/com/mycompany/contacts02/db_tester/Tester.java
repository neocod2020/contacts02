package com.mycompany.contacts02.db_tester;

import com.mycompany.contacts02.entity.Contact;
import com.mycompany.contacts02.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ААФ
 */
//@Component
public class Tester {

    @Autowired
    private ContactService service;

    Contact newContact = new Contact("Secondman", "Noname", "+7-921-2222222", "ON@gmail.com");

    public Tester() {
        System.out.println("public Tester()");
    }

    public void run() {

        Contact c = service.addContact(newContact);
        System.out.println("================================");
        System.out.println("Add contact");
        System.out.println(c);
        System.out.println("================================");
        System.out.println("");

        System.out.println("================================");
        System.out.println("Show all contacts");
        for (Contact cnt : service.getAllContacts()) {
            System.out.println(cnt);
        }
        System.out.println("================================");
        System.out.println("");

//        System.out.println("================================");
//        System.out.println("Remove contact #6");
//        service.deleteContact(6L);
//        for(Contact cnt : service.getAllContacts()) System.out.println(cnt);
//        System.out.println("================================");
//        System.out.println("");
        System.out.println("================================");
        System.out.println("Show contact #4");
        System.out.println(service.getContact(4L));
        System.out.println("================================");
        System.out.println("");

        System.out.println("================================");
        System.out.println("Show all contacts by surmame 'Noname'");
        for (Contact cnt : service.getAllContactsByLastName("Noname")) {
            System.out.println(cnt);
        }
        System.out.println("================================");
        System.out.println("");

        System.out.println("================================");
        System.out.println("Show all contacts by phone '+7-921-2222222'");
        for (Contact cnt : service.getAllContactsByPhone("+7-921-2222222")) {
            System.out.println(cnt);
        }
        System.out.println("================================");
        System.out.println("");

        System.out.println("================================");
        System.out.println("Show all contacts by email 'ON@gmail.com'");
        for (Contact cnt : service.getAllContactsByEmail("ON@gmail.com")) {
            System.out.println(cnt);
        }
        System.out.println("================================");
        System.out.println("");
    }
}
