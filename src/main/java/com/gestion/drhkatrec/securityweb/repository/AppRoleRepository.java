package com.gestion.drhkatrec.securityweb.repository;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.securityweb.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepository extends JpaRepository<Roles, Long> {

    Roles findByRolename(String Rolename);
}
