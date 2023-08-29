package com.gestion.drhkatrec.service;

import com.gestion.drhkatrec.entity.Bien;
import com.gestion.drhkatrec.entity.Users;

import java.util.ArrayList;
import java.util.Optional;

public interface BienIF {
    public Optional<Bien> Update(Long id);
    public ArrayList<Bien> findAll();

    void delete(Bien users);

    Optional<Bien> findById(long l);
}
