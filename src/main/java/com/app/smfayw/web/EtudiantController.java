package com.app.smfayw.web;

import com.app.smfayw.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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



}
