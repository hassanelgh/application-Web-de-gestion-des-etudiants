package com.app.smfayw.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @Enumerated(EnumType.STRING)
    private NomRole nomRole;

    @ManyToMany()
    private List<User> users=new ArrayList<>();
}
