package com.gestion.drhkatrec.controllor;

import com.gestion.drhkatrec.entity.Automobile;
import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.repositiry.AutomobileRepo;
import com.gestion.drhkatrec.repositiry.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AutoController {
    @Autowired
    private AutomobileRepo repo;
    @Autowired
    private UsersRepository userRepo;

    @GetMapping("/bienAutomobiles")
    String automobileshow(Model model){
        List<Users> usersList = userRepo.findAll();
        model.addAttribute("users", usersList);
        return "component/bienAutomobile";
    }
    @PostMapping("/user/addAuto")
    String addautomobile(@ModelAttribute Automobile automobile, BindingResult result){
        if (result.hasErrors()){
            return "component/bienAutomobile";
        }
        repo.save(automobile);
        return "component/bienAutomobile";
    }
}
