package com.app.smfayw.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {

    @Id
    private String id;

    @NotEmpty
    @Size(min = 2 ,max = 40)
    private String nom;

    @NotEmpty
    @Size(min = 2,max = 40)
    private String prenom;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private boolean enRegle;

}
