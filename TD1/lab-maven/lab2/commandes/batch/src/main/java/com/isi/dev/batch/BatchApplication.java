package com.isi.dev.batch;

import com.isi.dev.services.CommandesServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



    @Component
    public class BatchApplication implements CommandLineRunner {

        private CommandesServices commandesService;



        @Override
        public void run(String... args) {
            System.out.println("Batch job started...");
            commandesService.getCommandes();
            System.out.println("Batch job completed.");
        }
    }

