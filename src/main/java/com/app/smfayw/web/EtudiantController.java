package com.app.smfayw.web;

import com.app.smfayw.entites.Etudiant;
import com.app.smfayw.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
        if(taille<=0)
            taille=1;
        if(page<1){
            page=1;
        }
        Page<Etudiant> etudiantPage=etudiantRepository.findEtudiantByNomContains(cle, PageRequest.of(page-1,taille));
        System.out.println(page + "  " + etudiantPage.getTotalPages());
        if(page>etudiantPage.getTotalPages()){
            page=etudiantPage.getTotalPages();
            etudiantPage=etudiantRepository.findEtudiantByNomContains(cle, PageRequest.of(page-1,taille));
        }
        model.addAttribute("etudiants",etudiantPage);
        model.addAttribute("taille",taille);
        model.addAttribute("cle",cle);
        model.addAttribute("pageActuel",page);
        model.addAttribute("totalPage",etudiantPage.getTotalPages());
        model.addAttribute("pagination",pagination(etudiantPage,page));
        return "Etudiants";
    }

    private List<Integer> pagination(Page<Etudiant> etudiantPage ,int page){
        List<Integer> pagination=new ArrayList<>();
        int totalPages=etudiantPage.getTotalPages();
        if(totalPages<=5){
            for (int i=1;i<=etudiantPage.getTotalPages();i++)
                pagination.add(i);
        }else if (page-2<=0){
            int pf=totalPages>5 ? 5:totalPages;
            for (int i=1;i<=pf;i++)
                pagination.add(i);
        }else if(page+2>totalPages){
            int pi= totalPages-5>0?totalPages-5:0;
            for (int i=pi+1;i<=totalPages;i++)
                pagination.add(i);
        }else{
            for (int i=page-2;i<=page+2;i++)
                pagination.add(i);
        }


        return pagination;
    }

}
