package com.mycompany.contacts02.configuration;

import com.mycompany.contacts02.gui.ContactFrame;
import java.awt.EventQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ConfigurationToRunGUI {

    @Autowired
    ContactFrame frame;

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            EventQueue.invokeLater(() -> {
                frame.setVisible(true);
                frame.run();
            });
        };
    }
}
