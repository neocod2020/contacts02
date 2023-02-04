package com.mycompany.contacts02;

import com.mycompany.contacts02.db_tester.Tester;
import com.mycompany.contacts02.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class Contacts02Application
       // implements CommandLineRunner
{
//    @Autowired
//     ContactService service;
    
	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(ContactFrame.class)
//                        .headless(false)
//                        .run(args);
//                EventQueue.invokeLater(()-> {
//                ctx.getBean(ContactFrame.class)
//                        .setVisible(true);
//                });
/*
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Contacts02Application.class)
                        .headless(false)
                        .run(args);
        ctx.getBean(Tester.class).run();

//          SpringApplication.run(Tester.class, args);
	}
*/
        
        SpringApplication.run(Contacts02Application.class, args);
        
        }
     }
