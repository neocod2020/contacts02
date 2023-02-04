package com.mycompany.contacts02.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ААФ
 */

@Entity
@Table(name= "contacts")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long contactId;
    
    @Column(name="firstName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="email")
    private String email;

    public Contact() { }

    public Contact(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Contact(Long contactId, String firstName, String lastName, String phone, String email) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactId = " + contactId + ", firstName = " + firstName + ", lastName = " + lastName +
                ", phone = " + phone + ", email = " + email;
    }
}
