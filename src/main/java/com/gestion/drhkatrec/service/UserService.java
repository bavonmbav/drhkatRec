package com.gestion.drhkatrec.service;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.repositiry.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserIF {
    @Autowired
    public UsersRepository repo;
    @Override
    public Optional<Users> Update(Long id) {
        return repo.findById(id);
    }

    @Override
    public ArrayList<Users> findAll() {
        return (ArrayList<Users>) repo.findAll();
    }

    @Override
    public void delete(Users users) {
            repo.delete(users);
    }

    @Override
    public Optional<Users> findById(long l) {
        return repo.findById(l);
    }
}
