package com.app.smfayw;

import com.app.smfayw.entites.Etudiant;
import com.app.smfayw.entites.Genre;
import com.app.smfayw.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SmfaywApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmfaywApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args -> {

            etudiantRepository.save(new Etudiant(UUID.randomUUID().toString(),"el ghalbzouri","hassan","hassan@gmail.com",new Date(), Genre.MASCULIN,true));


        };
    }
}
