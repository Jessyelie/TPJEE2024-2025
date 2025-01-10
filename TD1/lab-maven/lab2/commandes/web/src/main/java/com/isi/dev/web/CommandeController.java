package com.isi.dev.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.isi.dev")
@ComponentScan(basePackages ={"com.isi.dev.services"})
public class CommandeController {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class,args);
        System.out.println("Démarage du serveur");
    }
}
