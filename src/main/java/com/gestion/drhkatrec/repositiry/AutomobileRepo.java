package com.gestion.drhkatrec.repositiry;

import com.gestion.drhkatrec.entity.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AutomobileRepo extends JpaRepository<Automobile, Long> {
}
