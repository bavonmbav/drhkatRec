package com.gestion.drhkatrec.securityweb.service;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.securityweb.entity.Roles;
import com.gestion.drhkatrec.securityweb.entity.Useres;

import java.util.ArrayList;
import java.util.Optional;

public interface SecurityService {

    Useres saveUser(String username, String password, String email, String stpassword);

    Roles saveRole(String rolename, String description);
    void addRoletoUser(String username, String rolename);
    void removeRoleforUser(String username, String rolename);
    public ArrayList<Useres> findAll();
    public ArrayList<Roles> findAlls();

    Useres loadUserByUserName(String username);

    void delete(Useres useres);

    Optional<Useres> findById(String l);

}
