package com.app.smfayw.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(){
        return "Connexion";
    }
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/Accueil";
    }

}
