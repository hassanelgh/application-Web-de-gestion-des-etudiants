#<h1 align="center">Student Management Fast As You Want (SMFAYW)</u>

## application Web de gestion des etudiants :
   * une application Web basée sur Spring MVC, Spring Data JPA et Spring Security qui permet de gérer des étudiants


###   creation de l'entité étudiant et leur repository :
   * Entite :(`src\main\java\com\app\smfayw\entites\Etudiant.java`)
   * repository : (`src\main\java\com\app\smfayw\repositories\EtudiantRepository.java`)
   * Chaque étudiant est défini par:
   ![entite etudiant](rapportImg/img1.png)



### partie web :
   * création de controlleur pour Etudiant (`src/main/java/com/app/smfayw/web/EtudiantController.java`)
   * création de deux routes :
   
   ![routes](rapportImg/img2.png)

   * création de mainTemplate.html (`src/main/resources/templates/mainTemplates/mainTemplate.html`) : contient navbar et deux fragments
     * fragment pour container de la page
     * fragment pour script
     
   * créationn de la page d'accueil (`src/main/resources/templates/Accueil.html`)
   
   ![page d'accueil](rapportImg/img3.png)
   
    * méthode `findEtudiantByNomContains`
   
   ![méthod](rapportImg/img4.png)

   * remplire la base de données par des fake données par dependancy :`jfairy`

   ![dependancy](rapportImg/img8.png)
   
   ![remplire la base de données](rapportImg/img7.png)

   * création de route :
   
   ![routes](rapportImg/img5.png)


   * création de la page Etudiants (`src/main/resources/templates/Etudiants.html`)

   ![page etudiants](rapportImg/img6.png)


   * pagination :
     * la fonction qui retourn liste des pages :
     
      ![page etudiants](rapportImg/img10.png)
   
   ![page etudiants](rapportImg/img9.png)


   * supprimer un etudiant:
     * route :

     ![route delete](rapportImg/img11.png)    
      
     * button supprimer
       
     ![button supprimer](rapportImg/img12.png)
     
     * fonction qui permet d'envoyer la requete Delete (utilisation de : ` JQuery AJAX`):

     ![fonction supprimer](rapportImg/img13.png)


   * ajouter un etudiant:
     * création de deux route :      
     
     ![route form etudiant ](rapportImg/img14.png)    

     ![route save etudiant](rapportImg/img15.png)    
     
     * création de la page FormEtudiant (`src/main/resources/templates/FormEtudiant.html`)

     ![page form etudiant](rapportImg/img16.png)    

     * validation de la formulaire :
       * ajouter la dependance : 

       ![dependancy](rapportImg/img17.png)
     
       * ajouter les annotations:

       ![les annotations](rapportImg/img18.png)

       * ajouter la validation dans la route save :

       ![les annotations](rapportImg/img19.png)

       * la formulaire :

       ![formulaire avec validation](rapportImg/img20.png)
        

   * édit un etudiant:
     * route:
     
     ![route edit un etudiant ](rapportImg/img21.png)    

     * button edit 

     ![button ](rapportImg/img22.png)

       * la page edit etudiant:(`src/main/resources/templates/EditEtudiant.html`)


