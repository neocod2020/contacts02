package com.mycompany.contacts02.configuration;

import com.mycompany.contacts02.db_tester.Tester;
import com.mycompany.contacts02.gui.ContactFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ААФ
 */
@Configuration
public class Contacts02Configuration {

    @Autowired
   //  ContactFrame frame;       
    Tester tester;

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            tester.run();
        };
    }
}
