package com.gestion.drhkatrec.controllor;

import com.gestion.drhkatrec.entity.Users;
import com.gestion.drhkatrec.repositiry.UsersRepository;
import com.gestion.drhkatrec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UsersRepository repo;
    @Autowired
    private UserService service;

    public ArrayList<Users> user;
    @GetMapping("/h")
    public String index(Model model)
    {
       user = service.findAll();
        model.addAttribute("users", user);
        return "/index";
    }
    @GetMapping("/addusers")
    public String adduser()
    {
        return "component/adduser";
    }
    @PostMapping("/adduser")
    public String add(@ModelAttribute Users u, BindingResult result)
    {
        System.out.println(u.toString());
        if (result.hasErrors()) {
            return "component/adduser";
        }
        u.genMatricule();
        repo.save(u);
       return "component/adduser";
    }
    @PostMapping("/update/{id}")
    String Update(@ModelAttribute Users users, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "component/update";
        }
        repo.save(users);
        return "redirect:/";

    }

    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable String id) {
        Optional<Users> users = service.Update(Long.parseLong(id));
        if (users.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("users", users.get());
        return "component/update";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        Optional<Users> usersdelete = service.findById(Long.parseLong(id));
        if (usersdelete.isEmpty()) {
            return "redirect:/";
        }
        service.delete(usersdelete.get());
        return "redirect:/";
    }

}
