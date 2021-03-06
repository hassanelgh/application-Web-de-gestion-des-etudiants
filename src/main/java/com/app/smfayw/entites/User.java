package com.app.smfayw.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    private String username;

    private String password;
    private boolean active;
    @ManyToMany(mappedBy = "users")
    private List<Role> roles=new ArrayList<>();
}
