package com.app.smfayw.repositories;

import com.app.smfayw.entites.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,String> {
    Page<Etudiant>findEtudiantByNomContains(String cle, Pageable pageable);
}
