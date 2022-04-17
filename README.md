#<h1 align="center">Student Management Fast As You Want (SMFAYW)</u>

## application Web de gestion des etudiants :
   * une application Web basée sur Spring MVC, Spring Data JPA et Spring Security qui permet de gérer des étudiants


###   creation de l'entité étudiant et leur repository :
   * Entite :(`src\main\java\com\app\smfayw\entites\Etudiant.java`)
   * repository : (`src\main\java\com\app\smfayw\repositories\EtudiantRepository.java`)
   * Chaque étudiant est défini par:
   ![entite etudiant](rapportImg/img1.png)



### partie web :
   * creation de controlleur pour Etudiant (`src/main/java/com/app/smfayw/web/EtudiantController.java`)
   * creation de deux routes :
     ![page d'accueil](rapportImg/img2.png)
   * creation de mainTemplate.html (`src/main/resources/templates/mainTemplates/mainTemplate.html`) : contient navbar et deux fragments
     * fragment pour container de la page
     * fragment pour script
     
   * creationn de la page d'accueil (`src/main/resources/templates/Accueil.html`)
     ![page d'accueil](rapportImg/img3.png)
   

