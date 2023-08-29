package com.gestion.drhkatrec.controllor;

import com.gestion.drhkatrec.entity.Bien;
import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.repositiry.BienRepository;
import com.gestion.drhkatrec.repositiry.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BienController {
    @Autowired
    private BienRepository repo;
    @Autowired
    private UsersRepository userRepo;

    @GetMapping("/biens")
    String bien(Model model){
        List<Users> usersList = userRepo.findAll();
        model.addAttribute("users", usersList);
       return "component/bien";
    }

    @PostMapping("/bien")
    String biens(@ModelAttribute Bien bien, BindingResult result){

        System.out.println(bien.toString());
        if (result.hasErrors()) {
            return "component/bien";
        }
        create(bien);
        return "component/bien";
    }

    public ResponseEntity<Bien>create(@ModelAttribute Bien bien){
        try {
            Bien newBien = new Bien();
            newBien.setAdresse(bien.getAdresse());
            newBien.setUsers(bien.getUsers());
            newBien.setNatureBien(bien.getNatureBien());
            repo.save(newBien);
            return ResponseEntity.ok(newBien);
        }catch (IllegalArgumentException e){

            return ResponseEntity.badRequest().build();
        }
    }

}
