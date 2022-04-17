package com.app.smfayw.web;

import com.app.smfayw.entites.Etudiant;
import com.app.smfayw.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;

    @GetMapping("/")
    public String index(){
        return "redirect:/Accueil";
    }
    @GetMapping("/Accueil")
    public String accueil(){
        return "Accueil";
    }


    @GetMapping("/User/Etudiants")
    public String etudiants(Model model ,
                            @RequestParam(name = "page" ,defaultValue = "0") int page,
                            @RequestParam(name = "taille",defaultValue = "5") int taille,
                            @RequestParam(name = "cle",defaultValue = "") String cle){

        Page<Etudiant> etudiantPage=etudiantRepository.findEtudiantByNomContains(cle, PageRequest.of(page,taille));
        model.addAttribute("etudiants",etudiantPage);
        model.addAttribute("taille",taille);
        model.addAttribute("cle",cle);

        return "Etudiants";
    }


}
