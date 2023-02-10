package com.mycompany.contacts02.configuration;

import com.mycompany.contacts02.db_tester.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class Contacts02ConfigurationToTestDbConnection {

    @Autowired      
    Tester tester;

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            tester.run();
        };
    }
}
