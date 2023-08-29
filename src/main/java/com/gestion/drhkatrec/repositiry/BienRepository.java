package com.gestion.drhkatrec.repositiry;

import com.gestion.drhkatrec.entity.Bien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienRepository extends JpaRepository<Bien, Long> {
}
