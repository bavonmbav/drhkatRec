package com.gestion.drhkatrec.service;

import com.gestion.drhkatrec.entity.Bien;
import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.repositiry.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class BienService implements BienIF{
    @Autowired
    private BienRepository repo;
    @Override
    public Optional<Bien> Update(Long id) {
        return repo.findById(id);
    }

    @Override
    public ArrayList<Bien> findAll() {
        return (ArrayList<Bien>) repo.findAll();
    }

    @Override
    public void delete(Bien users) {
        repo.delete(users);
    }

    @Override
    public Optional<Bien> findById(long l) {
        return repo.findById(l);
    }
}
