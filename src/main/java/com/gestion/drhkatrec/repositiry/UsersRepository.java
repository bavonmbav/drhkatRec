package com.gestion.drhkatrec.repositiry;

import com.gestion.drhkatrec.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long>{
    Optional<Users> findByMatricule(String matricule);
}
