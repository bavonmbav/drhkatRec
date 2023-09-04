package com.gestion.drhkatrec.securityweb.repository;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.securityweb.entity.Useres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<Useres, String> {

    Useres findByUsername(String username);

}
