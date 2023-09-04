package com.gestion.drhkatrec.securityweb.service;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.securityweb.entity.Roles;
import com.gestion.drhkatrec.securityweb.entity.Useres;

public interface SecurityService {

    Useres saveUser(String username, String password, String stpassword);
    Roles saveRole(String rolename, String description);
    void addRoletoUser(String username, String rolename);
    void removeRoleforUser(String username, String rolename);

    Useres loadUserByUserName(String username);
}
