package com.mycompany.contacts02.repository;

import com.mycompany.contacts02.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository     
public interface ContactRepository extends JpaRepository<Contact, Long> {
     
     Contact findById(long id);
  // public List<Contact> findAllContactsByFirstNameAndLastName(String name1, String name2);
//    @Query("select c from contacts c where c.firstName = :name1 and c.lastName = :name2")
//    public List<Contact> findAllContactsByFirstNameAndLastName(@Param("firstName")String name1, 
//           @Param("lastName") String name2);
}
