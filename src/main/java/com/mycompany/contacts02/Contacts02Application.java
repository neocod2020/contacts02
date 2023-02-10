package com.mycompany.contacts02;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Contacts02Application {

    public static void main(String[] args) {

        var ctx = new SpringApplicationBuilder(Contacts02Application.class)
                .headless(false)
                .run(args);
    }
}
