package com.isi.dev.start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.isi.dev")
@ComponentScan(basePackages = {"com.isi.dev.start.config","com.isi.dev.services.Repository", "com.isi.dev.web.Controller", "com.isi.dev.services.Service"})
@EnableJpaRepositories(basePackages = "com.isi.dev.services.Repository")
@EntityScan(basePackages = "com.isi.dev.services.Entity")
public class StartApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(StartApplication.class, args);
            System.out.println("Démarrage du serveur");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Beans in context:----------------------------------------");
//            for (String beanName : ctx.getBeanDefinitionNames()) {
//                System.out.println(beanName);
//            }
//            System.out.println("---------------------------------------------------------");
//        };
//    }
}
