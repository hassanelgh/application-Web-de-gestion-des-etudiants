package com.app.smfayw.repositories;

import com.app.smfayw.entites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,String> {
}
