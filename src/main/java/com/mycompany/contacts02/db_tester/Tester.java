package com.mycompany.contacts02.db_tester;

import com.mycompany.contacts02.entity.Contact;
import com.mycompany.contacts02.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ААФ
 */
@Component
public class Tester {

    @Autowired
    private ContactService service;

    Contact newContact = new Contact("Dastish", "Fantastish", "+7-921-5556663", "DF@gmail.com");

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
        for(Contact cnt : service.getAllContacts()) System.out.println(cnt);
        System.out.println("================================");
        System.out.println("");
        
        System.out.println("================================");
        System.out.println("Remove contact #3");
        service.deleteContact(3L);
        for(Contact cnt : service.getAllContacts()) System.out.println(cnt);
        System.out.println("================================");
        System.out.println("");
        
        System.out.println("================================");
        System.out.println("Show contact #4");
        System.out.println(service.getContact(4L));
        System.out.println("================================");
        System.out.println("");
    }

}
