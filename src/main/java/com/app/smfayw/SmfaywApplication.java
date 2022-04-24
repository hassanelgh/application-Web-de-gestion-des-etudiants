package com.app.smfayw;

import com.app.smfayw.entites.*;
import com.app.smfayw.repositories.EtudiantRepository;
import com.app.smfayw.repositories.RoleRepository;
import com.app.smfayw.repositories.UserRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class SmfaywApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmfaywApplication.class, args);
    }


    //@Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository){
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

            Role roleAdmin=new Role(NomRole.ADMIN,new ArrayList<>());
            Role roleUser=new Role(NomRole.USER,new ArrayList<>());

            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);

            User userAdmin=new User("admin", passwordEncoder.encode("0000"),true,new ArrayList<>());
            User userUser=new User("user", passwordEncoder.encode("0000"),true,new ArrayList<>());

            userRepository.save(userAdmin);
            userRepository.save(userUser);

            roleAdmin.getUsers().add(userAdmin);
            roleUser.getUsers().add(userAdmin);
            roleUser.getUsers().add(userUser);

            userAdmin.getRoles().add(roleAdmin);
            userAdmin.getRoles().add(roleUser);
            userUser.getRoles().add(roleUser);

            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
            userRepository.save(userAdmin);
            userRepository.save(userUser);

        };
    }
}
