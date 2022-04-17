package com.app.smfayw;

import com.app.smfayw.entites.Etudiant;
import com.app.smfayw.entites.Genre;
import com.app.smfayw.repositories.EtudiantRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class SmfaywApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmfaywApplication.class, args);
    }


    //@Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args -> {
            // initialiser les données (les etudiants) dans la base de donnée :

            Fairy fairy = Fairy.create();
            for (int i = 0; i < 100 ; i++) {
                Person person = fairy.person();
                Etudiant etudiant=new Etudiant();
                etudiant.setId(UUID.randomUUID().toString());
                etudiant.setNom(person.getLastName());
                etudiant.setPrenom(person.getFirstName());
                etudiant.setEmail(person.getEmail());
                etudiant.setDateNaissance(person.getDateOfBirth().toDate());
                etudiant.setGenre(person.isFemale()? Genre.FEMININ :Genre.MASCULIN);
                etudiant.setEnRegle(Math.random() >0.5);
                etudiantRepository.save(etudiant);

            }



        };
    }
}
