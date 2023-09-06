package com.gestion.drhkatrec.securityweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Useres {
    @Id
    private  String username_Id;
    @Column(unique = true)
    private  String username;
    private String email;
    private  String password;
    private boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Roles> appRoles = new ArrayList<>();

}
