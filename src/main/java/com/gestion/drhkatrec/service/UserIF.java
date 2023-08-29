package com.gestion.drhkatrec.service;

import com.gestion.drhkatrec.entity.Users;

import java.util.ArrayList;
import java.util.Optional;

public interface UserIF {
    public Optional<Users> Update(Long id);
    public ArrayList<Users> findAll();

    void delete(Users users);

    Optional<Users> findById(long l);

}
